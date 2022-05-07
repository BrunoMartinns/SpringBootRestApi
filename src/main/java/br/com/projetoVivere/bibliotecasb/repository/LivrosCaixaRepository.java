package br.com.projetoVivere.bibliotecasb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosCaixaRepository extends JpaRepository<LivrosCaixa, Integer> {
    List <LivrosCaixa> findByClientes(int clientes);

}
