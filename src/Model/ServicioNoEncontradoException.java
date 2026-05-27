package Model;

public class ServicioNoEncontradoException extends IllegalArgumentException {
    public ServicioNoEncontradoException(String message) {
        super(message);
    }
}
