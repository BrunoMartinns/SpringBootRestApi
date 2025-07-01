package br.com.projetoVivere.bibliotecasb.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoVivere.bibliotecasb.exception.ResourceNotFoundException;
import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.repository.ClientesRepository;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes inserir(Clientes clientes) {
        clientes.setDataCadastro(Date.from(Instant.now()));
        return clientesRepository.save(clientes);
    }

    public List<Clientes> buscarTodos() {
        return clientesRepository.findAll();
    }

    public Clientes buscarPorId(int id) {
        return clientesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));
    }

    public Clientes atualizar(Clientes clientes) {
        clientes.setDataCadastro(Date.from(Instant.now()));
        return clientesRepository.save(clientes);
    }

    public void deletarPorId(int id) {
    	
    	Clientes cliente = clientesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));
    	
        if (cliente != null) {
            throw new ResourceNotFoundException("Cliente não encontrado com ID: " + id);
        }
        clientesRepository.deleteById(id);
    }

    public Clientes buscarPorCpfCnpj(String cpfCnpj) {
        Clientes cliente = clientesRepository.findByCpfCnpj(cpfCnpj);
        if (cliente == null) {
            throw new ResourceNotFoundException("Cliente não encontrado com CPF/CNPJ: " + cpfCnpj);
        }
        return cliente;
    }

    public List<Clientes> buscarPorCidade(String cidade) {
        return clientesRepository.findByCidadeContaining(cidade);
    }
}

