package br.com.projetoVivere.bibliotecasb.controllers;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.repository.ClientesRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientesControllers {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@PostMapping
	public @ResponseBody Clientes novoCliente (Clientes clientes) {
		Date date = Date.from(Instant.now());
		clientes.setDataCadastro(date);
		clientes = clientesRepository.save(clientes);
		return clientes;
	}
	
	
	//Obter a lista de Clientes
	@GetMapping(path="/all")
	public ResponseEntity<List<Clientes>> obterClientes() {
		List<Clientes> clients = clientesRepository.findAll();
		return ResponseEntity.ok().body(clients);
	}
	
	//Obter a lista de Clientes por ID
	@GetMapping(path="/id/{id}")
	public ResponseEntity<Clientes> obterClientesId(@PathVariable(value= "id") int id) {
		Clientes clients = clientesRepository.findById(id).orElse(null);
		return ResponseEntity.ok().body(clients);

		
	}
	
	//Alterar cliente
	@PutMapping
	public ResponseEntity<Clientes> alterarClientes(Clientes clientes) {
		Date date = Date.from(Instant.now());
		clientes.setDataCadastro(date);
		clientes = clientesRepository.save(clientes);
		return ResponseEntity.ok().body(clientes);
	}
	
	//Deletar cliente
	@DeleteMapping(path="/{id}")
	public ResponseEntity deletarClientes(@PathVariable(value= "id") int id) {
		clientesRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path="/{cpfCnpj}")
	public ResponseEntity<Clientes> obterClientesCpfCnpj(@PathVariable(value= "cpfCnpj")String cpfCnpj) {
		Clientes clients = clientesRepository.findByCpfCnpj(cpfCnpj);
		return ResponseEntity.ok().body(clients);
	}
	
	@GetMapping(path="/cidade/{cidade}")
	public Iterable<Clientes> obterClientesCidade(@PathVariable(value= "cidade")String cidade){
		return clientesRepository.findByCidadeContaining(cidade);
	}
	

}
