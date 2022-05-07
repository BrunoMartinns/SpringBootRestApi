package br.com.projetoVivere.bibliotecasb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoVivere.bibliotecasb.models.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNome(String nome);

	Usuario findByLoginAndSenha(String login, String senha);
}
