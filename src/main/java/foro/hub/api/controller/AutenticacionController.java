package foro.hub.api.controller;

import foro.hub.api.domain.usuario.DatosAutenticacion;
import foro.hub.api.domain.usuario.Usuario;
import foro.hub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos) {
        var token = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var autenticacion = manager.authenticate(token);

        return ResponseEntity.ok(tokenService.generarToken((Usuario) autenticacion.getPrincipal()));
    }
}
