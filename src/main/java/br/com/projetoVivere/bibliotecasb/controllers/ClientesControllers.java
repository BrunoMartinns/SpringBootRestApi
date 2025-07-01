package br.com.projetoVivere.bibliotecasb.controllers;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.repository.ClientesRepository;
import br.com.projetoVivere.bibliotecasb.service.ClientesService;

@RestController
@RequestMapping("/api/clientes")
public class ClientesControllers {
	
	@Autowired
	private ClientesService service;
	
	@PostMapping
	public @ResponseBody ResponseEntity<Clientes> inserir(@RequestBody Clientes clientes) {
		 Clientes novo = service.inserir(clientes);
	     return ResponseEntity.status(HttpStatus.CREATED).body(novo);
	}
	
	//Obter a lista de Clientes
	@GetMapping(path="/all")
	public ResponseEntity<List<Clientes>> buscarTodos() {
		List<Clientes> clients = service.buscarTodos();
		return ResponseEntity.ok(clients);
	}
	
	//Obter a lista de Clientes por ID
	@GetMapping(path="/id/{id}")
	public ResponseEntity<Clientes> buscarPorId(@PathVariable(value= "id") int id) {
		return ResponseEntity.ok(service.buscarPorId(id));
		
	}
	//Alterar cliente
	@PutMapping
	public ResponseEntity<Clientes> atualizar(@RequestBody Clientes clientes) {
		Clientes atualizado = service.atualizar(clientes);
        return ResponseEntity.ok(atualizado);
	}
	
	//Deletar cliente
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deletar(@PathVariable(value= "id") int id) {
		service.deletarPorId(id);
        return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path="/{cpfCnpj}")
	public ResponseEntity<Clientes> obterClientesCpfCnpj(@PathVariable(value= "cpfCnpj")String cpfCnpj) {
		return ResponseEntity.ok(service.buscarPorCpfCnpj(cpfCnpj));
	}
	
	@GetMapping(path="/cidade/{cidade}")
	public ResponseEntity<List<Clientes>> obterClientesCidade(@PathVariable(value= "cidade")String cidade){
		return ResponseEntity.ok(service.buscarPorCidade(cidade));
	}
	

}
