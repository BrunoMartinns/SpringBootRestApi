package br.com.projetoVivere.bibliotecasb.controllers;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import br.com.projetoVivere.bibliotecasb.models.Usuario;
import br.com.projetoVivere.bibliotecasb.repository.UsuarioRepository;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioControllers {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public @ResponseBody Usuario novoUsuario(Usuario usuario) {
		Date date = Date.from(Instant.now());
		usuario.setDataCadastro(date);
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(Usuario usuario) {
		Date date = Date.from(Instant.now());
		usuario.setDataCadastro(date);
		Usuario user = usuarioRepository.save(usuario);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity deletarUsuario(@PathVariable(value= "id") int id) {
		usuarioRepository.deleteById((int) id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable(value= "id") int id){
		Usuario user = usuarioRepository.findById(id).orElse(null);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping()
	public ResponseEntity<Usuario> obterUsuarioPorNome(@RequestParam(value="nome") String nome){
		Usuario user = usuarioRepository.findByNome(nome).orElse(null);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/login")
	public String loginUser(@RequestBody Usuario usuario) {
		Usuario login = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		if (login != null) {
			if (login.getStatus().equals("A")) {
				return "Logged in";
			} else {
				return "Usuario inativo!";
			}
		} else {
			return "Usuario ou senha Invalida!";
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List <Usuario>> todosUsuarios(){
		List<Usuario> user = usuarioRepository.findAll();
		return ResponseEntity.ok().body(user);
	}
}
