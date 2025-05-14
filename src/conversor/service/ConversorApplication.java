package conversor.service;

import conversor.excecao.MoedaInvalidaException;
import conversor.model.Usuario;

public class ConversorApplication {
    public static void main(String[] args) {
        MenuService menu = new MenuService();
        ConversorService conversor = new ConversorService();

        boolean continuar = true;

        while (continuar) {
            System.out.println("==================================");
            System.out.println(" Bem-vindo ao Conversor de Moedas ");
            System.out.println("==================================");

            Usuario usuario = menu.menu();

            try {
                double resultado = conversor.converter(usuario);
                System.out.printf("Valor convertido: %.2f %s%n%n", resultado, usuario.getMoedaDestino());
            } catch (MoedaInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }

            continuar = menu.desejaContinuar();
        }

        System.out.println("Obrigado por usar o conversor de moedas!");
    }
}
