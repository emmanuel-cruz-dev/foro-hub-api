package foro.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull String idAutor,
        @NotBlank(message = "El mensaje es obligatorio")
        String mensaje,
        @NotBlank(message = "El nombre del curso es obligatorio")
        String nombreCurso,
        @NotBlank(message = "El título es obligatorio")
        String titulo
) {
}
