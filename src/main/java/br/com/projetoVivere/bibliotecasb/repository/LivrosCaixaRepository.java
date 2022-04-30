package br.com.projetoVivere.bibliotecasb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;

public interface LivrosCaixaRepository extends JpaRepository<LivrosCaixa, Integer> {

	Optional<LivrosCaixa> findByIdCliente(Optional<Clientes> clientes);

}
