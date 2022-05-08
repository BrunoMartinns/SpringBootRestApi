package br.com.projetoVivere.bibliotecasb.controllers;

import java.util.List;

import br.com.projetoVivere.bibliotecasb.dto.LivrosCaixaDTO;
import br.com.projetoVivere.bibliotecasb.service.LivrosCaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;

@RestController
@RequestMapping("/api/livrosCaixa")
public class LivrosCaixaControllers {
	

	@Autowired
	private LivrosCaixaService livrosCaixaService;

	@PostMapping()
	public ResponseEntity<LivrosCaixa> inserirLivrosCaixa(LivrosCaixaDTO livrosCaixaDTO) {
		LivrosCaixa caixaLivros = livrosCaixaService.inserirLivrosCaixa(livrosCaixaDTO);
		return ResponseEntity.ok().body(caixaLivros);
	}
	
	@PutMapping()
	public ResponseEntity<LivrosCaixa> editarLivrosCaixa(@RequestBody LivrosCaixaDTO livrosCaixaDTO) {
		LivrosCaixa livrosCaixa = livrosCaixaService.editarLivrosCaixa(livrosCaixaDTO);
		return ResponseEntity.ok().body(livrosCaixa);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<LivrosCaixa> excluirLivrosCaixa( LivrosCaixa livrosCaixa) {
		livrosCaixaService.excluirLivrosCaixa(livrosCaixa);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/id/{id}")
	public ResponseEntity<LivrosCaixa> buscarLivroCaixa(@PathVariable(value= "id")int id){
		LivrosCaixa livrosCaixa = livrosCaixaService.buscarLivroCaixaId(id);
		return ResponseEntity.ok().body(livrosCaixa);
	}
	
	@GetMapping(value="/idclientes/{id}")
	public ResponseEntity<List<LivrosCaixa>> buscarLivroCaixaIdCliente(@PathVariable(value ="id") int idClientes){
		List<LivrosCaixa> livrosCaixa = livrosCaixaService.ByclientId(idClientes);
		return ResponseEntity.ok().body(livrosCaixa);
	}

//	@GetMapping("/clientId/{id}")
//	public ResponseEntity < List <Cashbook>>  getCashbookByClientId(@PathVariable(value = "id") int client) {
//		List <Cashbook> cashS = cashbookService.ByclientId(client);
//
//		return ResponseEntity.ok().body(cashS);
//
//	}

}
