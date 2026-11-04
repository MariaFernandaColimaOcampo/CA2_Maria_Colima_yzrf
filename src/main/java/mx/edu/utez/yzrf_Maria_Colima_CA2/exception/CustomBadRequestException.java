package mx.edu.utez.yzrf_Maria_Colima_CA2.exception;

public class CustomBadRequestException extends RuntimeException {
    public CustomBadRequestException(String mensaje) {
        super(mensaje);
    }
}