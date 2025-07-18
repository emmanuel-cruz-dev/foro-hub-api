package foro.hub.api.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank String nombreCurso,
        @NotBlank String categoria
) {
}
