package br.com.projetoVivere.bibliotecasb.service;

import br.com.projetoVivere.bibliotecasb.dto.LivrosCaixaDTO;
import br.com.projetoVivere.bibliotecasb.exception.ResourceNotFoundException;
import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;
import br.com.projetoVivere.bibliotecasb.repository.ClientesRepository;
import br.com.projetoVivere.bibliotecasb.repository.LivrosCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LivrosCaixaService {

    @Autowired
    private LivrosCaixaRepository livrosCaixaRepository;
    @Autowired
    private ClientesRepository clientesRepository;


    @Transactional
    public LivrosCaixa inserirLivrosCaixa(LivrosCaixaDTO livrosCaixaDTO){
        Clientes clientes = clientesRepository.findById(livrosCaixaDTO.getClientes()).orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado!"));
        LivrosCaixa caixaLivros = new LivrosCaixa(livrosCaixaDTO.getDatalancamento(), livrosCaixaDTO.getDescricao(), livrosCaixaDTO.getType(), livrosCaixaDTO.getValor(), clientes);
        caixaLivros = livrosCaixaRepository.save(caixaLivros);
        return caixaLivros;
    }


    public LivrosCaixa editarLivrosCaixa(LivrosCaixaDTO livrosCaixaDTO) {
        livrosCaixaRepository.findById(livrosCaixaDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("LivrosCaixa nao encontrado!"));
        Clientes clientes = clientesRepository.findById(livrosCaixaDTO.getClientes()).orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado!"));
        LivrosCaixa caixaLivros = new LivrosCaixa(livrosCaixaDTO.getDatalancamento(), livrosCaixaDTO.getDescricao(), livrosCaixaDTO.getType(), livrosCaixaDTO.getValor(), clientes);
        Date dt = Date.from(Instant.now());
        clientes.setDataCadastro(dt);
        caixaLivros = livrosCaixaRepository.save(caixaLivros);
        return caixaLivros;
    }


    public void excluirLivrosCaixa(LivrosCaixa livrosCaixa) {
        livrosCaixaRepository.delete(livrosCaixa);
    }

    public LivrosCaixa buscarLivroCaixaId(int id){
        return this.livrosCaixaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LivrosCaixa nao encontrado!"));
    }

    public List<LivrosCaixa> ByclientId(int clientes) {

        return this.livrosCaixaRepository.findByClientes(clientes);
    }






}
