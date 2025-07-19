package foro.hub.api.domain.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Curso {
    @Column(name = "curso")
    private String nombreCurso;
    @Column(name = "categoria")
    private String categoria;
}
