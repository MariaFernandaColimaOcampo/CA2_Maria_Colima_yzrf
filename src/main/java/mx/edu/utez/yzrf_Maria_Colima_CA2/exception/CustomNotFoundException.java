package mx.edu.utez.yzrf_Maria_Colima_CA2.exception;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String mensaje) {
        super(mensaje);
    }
}