package br.com.projetoVivere.bibliotecasb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoVivere.bibliotecasb.models.Usuario;
import br.com.projetoVivere.bibliotecasb.repository.UsuarioRepository;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String autenticar(Usuario usuario) {
        Usuario login = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());

        if (login != null) {
            if ("A".equalsIgnoreCase(login.getStatus())) {
                return "Conectado!";
            } else {
                return "Usuário inativo!";
            }
        } else {
            return "Usuário ou senha inválida!";
        }
    }
}

