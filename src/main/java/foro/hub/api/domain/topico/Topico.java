package foro.hub.api.domain.topico;

import foro.hub.api.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Embedded
    private Curso nombreCurso;

    private Long idAutor;
    private LocalDateTime fechaCreacion;
    private boolean status;

    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.nombreCurso = new Curso(datos.nombreCurso(), datos.categoria());
        this.idAutor = Long.valueOf(datos.idAutor());
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
    }
}
