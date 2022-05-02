package br.com.projetoVivere.bibliotecasb.controllers;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;
import br.com.projetoVivere.bibliotecasb.repository.ClientesRepository;
import br.com.projetoVivere.bibliotecasb.repository.LivrosCaixaRepository;

@Controller
public class LivrosCaixaControllers {
	
	@Autowired
	private LivrosCaixaRepository livrosCaixaRepository;
	@Autowired
	private ClientesRepository clientesRepository;
	
	
	@Transactional
	public @ResponseBody LivrosCaixa inserirLivrosCaixa(LivrosCaixa livrosCaixa) {
		Clientes clientes = clientesRepository.findById(livrosCaixa.getClientes().getId());
		LivrosCaixa caixaLivros = new LivrosCaixa(livrosCaixa.getDatalancamento(), livrosCaixa.getDescricao(), livrosCaixa.getType(), livrosCaixa.getValor(), clientes);
		caixaLivros = livrosCaixaRepository.save(livrosCaixa);
		return caixaLivros;
	}
	
	@PutMapping
	public LivrosCaixa editarLivrosCaixa(LivrosCaixa livrosCaixa) {
		livrosCaixaRepository.findById(livrosCaixa.getId());
		Clientes clientes = clientesRepository.findById(livrosCaixa.getClientes().getId());
		Date dt = Date.from(Instant.now());
		clientes.setDataCadastro(dt);
		livrosCaixa = livrosCaixaRepository.save(livrosCaixa);
		return livrosCaixaRepository.save(livrosCaixa);
	}
	
	@DeleteMapping
	public void excluirLivrosCaixa(LivrosCaixa livrosCaixa) {
		livrosCaixaRepository.delete(livrosCaixa);
	}
	
	@GetMapping(name="/{id}")
	public Optional<LivrosCaixa> buscarLivroCaixaId(@PathVariable(value= "id")long id){
		return livrosCaixaRepository.findById((int) id);
	}
	
	@GetMapping(name="/{idCliente}")
	public Optional<LivrosCaixa> buscarLivroCaixaIdCliente(@PathVariable(value= "nome") long idCliente){
		LivrosCaixa livrosCaixa;
		return livrosCaixaRepository.findByIdCliente(clientesRepository.findById((int) idCliente));
	}

}
