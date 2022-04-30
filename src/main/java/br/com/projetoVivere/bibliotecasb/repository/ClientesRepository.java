package br.com.projetoVivere.bibliotecasb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoVivere.bibliotecasb.models.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

	List<Clientes> findByCpfCnpj(String cpfCnpj);
	List<Clientes> findByCidade(String cidade);
	Clientes findById(Long id);
	
	

}
