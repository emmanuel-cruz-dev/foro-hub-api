package foro.hub.api.controller;

import foro.hub.api.domain.topico.DatosRegistroTopico;
import foro.hub.api.domain.topico.Topico;
import foro.hub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public String registrar(@RequestBody DatosRegistroTopico datos) {
        repository.save(new Topico(datos));
        return "Tópico registrado correctamente.";
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "Tópico eliminado correctamente.";
    }
}
