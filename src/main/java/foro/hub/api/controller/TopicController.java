package foro.hub.api.controller;

import foro.hub.api.topic.DataRegisterTopic;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @PostMapping
    public void register(@RequestBody DataRegisterTopic data) {
        System.out.println(data);
    }
}
