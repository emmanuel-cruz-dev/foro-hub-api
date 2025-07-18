package foro.hub.api.domain.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Curso {
    @Column(name = "nombreCurso")
    private String nombreCurso;
    @Column(name = "categoria")
    private String categoria;
}
