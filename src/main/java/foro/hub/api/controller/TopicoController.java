package foro.hub.api.controller;

import foro.hub.api.domain.topic.DatosRegistroTopico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @PostMapping
    public void registrar(@RequestBody DatosRegistroTopico data) {
        System.out.println(data);
    }
}
