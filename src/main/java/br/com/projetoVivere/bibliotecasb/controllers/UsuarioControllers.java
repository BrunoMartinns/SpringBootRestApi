package br.com.projetoVivere.bibliotecasb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import br.com.projetoVivere.bibliotecasb.models.Usuario;
import br.com.projetoVivere.bibliotecasb.repository.UsuarioRepository;

@Controller
public class UsuarioControllers {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public @ResponseBody Usuario novoUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	@PutMapping
	public Usuario editarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	@DeleteMapping(path="/{id}")
	public void deletarUsuario(@PathVariable(value= "id") long id) {
		usuarioRepository.deleteById((int) id);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Usuario> obterUsuarioId(@PathVariable(value= "id") long id){
		return usuarioRepository.findById((int)id);
	}
	
	@GetMapping(path="/{nome}")
	public Optional<Usuario> obterUsuarioId(@PathVariable(value= "nome") String nome){
		return usuarioRepository.findByNome(nome);
	}

}
