package foro.hub.api.controller;

import foro.hub.api.domain.topico.DatosActualizarTopico;
import foro.hub.api.domain.topico.DatosRegistroTopico;
import foro.hub.api.domain.topico.Topico;
import foro.hub.api.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<String> registrar(@Valid @RequestBody DatosRegistroTopico datos) {
        try{
            repository.save(new Topico(datos));
            return ResponseEntity.status(201).body("Tópico registrado correctamente.");
        } catch (DataIntegrityViolationException e) {
            throw e;
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: No se pudo registrar el tópico ");
        }

    }

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        try{
            List<Topico> topicos = repository.findAll();
            return ResponseEntity.ok(topicos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerTopicoPorId(@PathVariable Long id) {
        try {
            Topico topico = repository.findById(id).orElse(null);

            if (topico == null) {
                return ResponseEntity.status(404).body("Error: Tópico no encontrado");
            }

            return ResponseEntity.ok(topico);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: No se pudo obtener el tópico");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody DatosActualizarTopico datos) {
        try {
            Topico topico = repository.findById(id).orElse(null);

            if (topico == null) {
                return ResponseEntity.status(404).body("Error: Tópico no encontrado");
            }
            topico.actualizarDatos(datos);
            repository.save(topico);

            return ResponseEntity.ok("Tópico actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: No se pudo actualizar el tópico");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            if (!repository.existsById(id)) {
                return ResponseEntity.status(404).body("Error: Tópico no encontrado");
            }
            repository.deleteById(id);

            return ResponseEntity.ok("Tópico eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: No se pudo eliminar el tópico");
        }
    }
}
