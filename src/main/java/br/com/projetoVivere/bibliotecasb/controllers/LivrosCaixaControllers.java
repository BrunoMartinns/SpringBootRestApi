package br.com.projetoVivere.bibliotecasb.controllers;

import java.util.Date;
import java.util.List;

import br.com.projetoVivere.bibliotecasb.dto.LivrosCaixaDTO;
import br.com.projetoVivere.bibliotecasb.dto.RelatorioContabilDTO;
import br.com.projetoVivere.bibliotecasb.service.LivrosCaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;

@RestController
@RequestMapping("/api/livros-caixa")
public class LivrosCaixaControllers {
	

	@Autowired
	private LivrosCaixaService livrosCaixaService;

	@PostMapping()
	public ResponseEntity<LivrosCaixa> inserir(@RequestBody LivrosCaixaDTO livrosCaixaDTO) {
		LivrosCaixa novo = livrosCaixaService.inserirLivrosCaixa(livrosCaixaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novo);
	}
	
	@PutMapping()
	public ResponseEntity<LivrosCaixa> editar(@RequestBody LivrosCaixaDTO livrosCaixaDTO) {
		LivrosCaixa atualizado = livrosCaixaService.editarLivrosCaixa(livrosCaixaDTO);
		return ResponseEntity.ok().body(atualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LivrosCaixa> excluirLivrosCaixa(@PathVariable(value= "id") int id) {
		livrosCaixaService.excluirLivrosCaixa(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/id/{id}")
	public ResponseEntity<LivrosCaixa> buscarLivroCaixa(@PathVariable(value= "id") int id){
		LivrosCaixa encontrado = livrosCaixaService.buscarLivroCaixaPorId(id);
		return ResponseEntity.ok().body(encontrado);
	}
	
	@GetMapping(value="/idclientes/{id}")
	public ResponseEntity<List<LivrosCaixa>> buscarLivroCaixaIdCliente(@PathVariable(value ="id") int idClientes){
		List<LivrosCaixa> lista = livrosCaixaService.buscarLivrosCaixaPorClienteId(idClientes);
		return ResponseEntity.ok().body(lista);
	}

}
