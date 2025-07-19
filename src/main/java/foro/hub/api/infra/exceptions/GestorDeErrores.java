package foro.hub.api.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GestorDeErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Error: Campos inválidos o faltantes");
    }
}
