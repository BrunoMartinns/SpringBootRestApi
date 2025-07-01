package br.com.projetoVivere.bibliotecasb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projetoVivere.bibliotecasb.dto.UsuarioDTO;
import br.com.projetoVivere.bibliotecasb.models.Usuario;
import br.com.projetoVivere.bibliotecasb.service.UsuarioService;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioControllers {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public @ResponseBody ResponseEntity<Usuario> novoUsuario(@RequestBody UsuarioDTO usuario) {
		Usuario novo = service.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		Usuario editado = service.editar(usuario);
        return ResponseEntity.ok(editado);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable(value= "id") int id) {
		service.deletarPorId(id);
        return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable(value= "id") int id){
		Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
	}
	
	@GetMapping(path="/nome")
	public ResponseEntity<Usuario> obterUsuarioPorNome(@RequestParam(value="nome") String nome){
		Usuario usuario = service.buscarPorNome(nome);
        return ResponseEntity.ok(usuario);
	}

	@GetMapping("/all")
	public ResponseEntity<List <Usuario>> todosUsuarios(){
		List<Usuario> usuarios = service.buscarTodos();
        return ResponseEntity.ok(usuarios);
	}
}
