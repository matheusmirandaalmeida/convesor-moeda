package conversor.excecao;

public class MoedaInvalidaException extends RuntimeException {
    public MoedaInvalidaException(String message) {
        super(message);
    }
}
