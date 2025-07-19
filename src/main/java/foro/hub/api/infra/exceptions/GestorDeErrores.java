package foro.hub.api.infra.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> manejarErroresDeDuplicados(DataIntegrityViolationException ex) {
        if (ex.getMessage().contains("titulo") || ex.getMessage().contains("mensaje")) {
            return ResponseEntity.badRequest().body("Error: Ya existe un tópico con el mismo título y mensaje");
        }
        return ResponseEntity.badRequest().body("Error: Violación de integridad de datos");
    }
}
