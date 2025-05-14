package conversor.service;

import conversor.model.Usuario;

import java.util.Scanner;

public class MenuService {
    private final Scanner sc = new Scanner(System.in);

    public Usuario menu() {
        String moedaOrigem = lerMoeda("Digite a moeda de origem (ex: USD): ");
        String moedaDestino = lerMoeda("Digite a moeda de destino (ex: BRL): ");
        double valor = lerValor();

        return new Usuario(moedaOrigem, moedaDestino, valor);
    }

    private String lerMoeda(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim().toUpperCase();

            if (entrada.matches("[A-Z]{3}")) {
                return entrada;
            } else {
                System.out.println("Código de moeda inválido. Use 3 letras (ex: USD, EUR, BRL).");
            }
        }
    }

    private double lerValor() {
        while (true) {
            System.out.print("Digite a quantidade a ser convertida: ");
            try {
                double valor = Double.parseDouble(sc.nextLine().trim());
                if (valor > 0) {
                    return valor;
                } else {
                    System.out.println("O valor deve ser maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido (ex: 100.50).");
            }
        }
    }

    public boolean desejaContinuar() {
        while (true) {
            System.out.print("Deseja converter outra moeda? (S/N): ");
            String resposta = sc.nextLine().trim().toUpperCase();
            if (resposta.equals("S")) return true;
            if (resposta.equals("N")) return false;
            System.out.println("Opção inválida. Digite S para sim ou N para não.");
        }
    }
}
