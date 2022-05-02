package br.com.projetoVivere.bibliotecasb.controllers;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Clientes> obterClientes() {
		return clientesRepository.findAll();
	}
	
	//Obter a lista de Clientes por ID
	@GetMapping(path="/{id}")
	public Optional<Clientes> obterClientesId(@PathVariable(value= "id") long id) {
		return clientesRepository.findById((int) id);
		
	}
	
	//Alterar cliente
	@PutMapping
	public Clientes alterarClientes(Clientes clientes) {
		Date date = Date.from(Instant.now());
		clientes.setDataCadastro(date);
		clientes = clientesRepository.save(clientes);
		return clientes;
	}
	
	//Deletar cliente
	@DeleteMapping(path="/{id}")
	public void deletarClientes(@PathVariable(value= "id") long id) {
		clientesRepository.deleteById((int) id);
	}
	
	@GetMapping(path="/{cpfCnpj}")
	public List<Clientes> obterClientesCpfCnpj(@PathVariable(value= "cpfCnpj")String cpfCnpj) {
		return clientesRepository.findByCpfCnpj(cpfCnpj);
	}
	
	@GetMapping(path="/{cidade}")
	public List<Clientes> obterClientesCidade(@PathVariable(value= "cidade")String cidade){
		return clientesRepository.findByCidade(cidade);
	}
	

}
