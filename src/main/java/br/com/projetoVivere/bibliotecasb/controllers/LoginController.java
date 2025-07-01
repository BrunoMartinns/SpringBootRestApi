package br.com.projetoVivere.bibliotecasb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoVivere.bibliotecasb.models.Usuario;
import br.com.projetoVivere.bibliotecasb.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity<String> autenticar(@RequestBody Usuario usuario) {
        String resposta = service.autenticar(usuario);
        return ResponseEntity.ok(resposta);
    }
}