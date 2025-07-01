package br.com.projetoVivere.bibliotecasb.service;

import br.com.projetoVivere.bibliotecasb.dto.LivrosCaixaDTO;
import br.com.projetoVivere.bibliotecasb.dto.RelatorioContabilDTO;
import br.com.projetoVivere.bibliotecasb.exception.ResourceNotFoundException;
import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;
import br.com.projetoVivere.bibliotecasb.repository.ClientesRepository;
import br.com.projetoVivere.bibliotecasb.repository.LivrosCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LivrosCaixaService {

    @Autowired
    private LivrosCaixaRepository livrosCaixaRepository;
    
    @Autowired
    private ClientesRepository clientesRepository;


    @Transactional
    public LivrosCaixa inserirLivrosCaixa(LivrosCaixaDTO caixa){
        Clientes clientes = clientesRepository.findById(caixa.getClienteId()).orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado!"));
        LivrosCaixa novo = new LivrosCaixa(caixa.getDatalancamento(), caixa.getDescricao(), caixa.getTipo(), caixa.getValor(), clientes);
        novo = livrosCaixaRepository.save(novo);
        
        return novo;
    }


    public LivrosCaixa editarLivrosCaixa(LivrosCaixaDTO livrosCaixaDTO) {
        
    	LivrosCaixa caixaLivros = livrosCaixaRepository.findById(livrosCaixaDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("LivrosCaixa nao encontrado!"));
    	Clientes clientes = clientesRepository.findById(livrosCaixaDTO.getClienteId()).orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado!"));
    	
        
    	caixaLivros.setDatalancamento(livrosCaixaDTO.getDatalancamento());
        caixaLivros.setDescricao(livrosCaixaDTO.getDescricao());
        caixaLivros.setTipo(livrosCaixaDTO.getTipo());
        caixaLivros.setValor(livrosCaixaDTO.getValor());
        caixaLivros.setClientes(clientes);

        return livrosCaixaRepository.save(caixaLivros);
    }


    public void excluirLivrosCaixa(int id) {
    	LivrosCaixa livro = livrosCaixaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro Caixa não encontrado com ID: " + id));
    	livrosCaixaRepository.delete(livro);
    }

    public LivrosCaixa buscarLivroCaixaPorId(int id){
        return this.livrosCaixaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro Caixa não encontrado com ID: " + id));
    }

    public List<LivrosCaixa> buscarLivrosCaixaPorClienteId(int idCliente) {
    	 Clientes cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + idCliente + " não encontrado"));

    	List<LivrosCaixa> livros = livrosCaixaRepository.findByClientes(cliente);
        
        if (livros.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum Livro Caixa encontrado para o cliente com ID: " + idCliente);
        }
        
        return livros;
        
    }
}
