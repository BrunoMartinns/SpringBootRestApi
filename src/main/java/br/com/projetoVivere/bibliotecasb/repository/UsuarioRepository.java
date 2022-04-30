package br.com.projetoVivere.bibliotecasb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoVivere.bibliotecasb.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNome(String nome);

}
