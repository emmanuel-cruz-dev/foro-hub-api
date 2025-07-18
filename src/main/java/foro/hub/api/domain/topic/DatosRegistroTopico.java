package foro.hub.api.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull String idAutor,
        @NotBlank String mensaje,
        @NotBlank String nombreCurso,
        @NotBlank String titulo,
        @NotBlank String categoria
) {
}
