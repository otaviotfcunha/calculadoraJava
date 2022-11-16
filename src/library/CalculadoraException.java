package library;

public class CalculadoraException extends Exception{
    private int codigoErro;

    public CalculadoraException(int codigoErro){
        this.codigoErro = codigoErro;
    }

    @Override
    public String getMessage() {
        return switch (codigoErro) {
            case 1 -> "Impossível divisão por 0.";
            case 2 -> "Número inválido para a operação.";
            default -> "Código de erro inexistente.";
        };
    }

}
