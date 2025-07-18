package foro.hub.api.controller;

import foro.hub.api.domain.topic.DatosRegistroTopico;
import foro.hub.api.domain.topic.Topico;
import foro.hub.api.domain.topic.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void registrar(@RequestBody DatosRegistroTopico datos) {
        repository.save(new Topico(datos));
    }
}
