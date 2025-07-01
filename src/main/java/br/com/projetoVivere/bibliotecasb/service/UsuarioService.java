package br.com.projetoVivere.bibliotecasb.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoVivere.bibliotecasb.dto.UsuarioDTO;
import br.com.projetoVivere.bibliotecasb.exception.ResourceNotFoundException;
import br.com.projetoVivere.bibliotecasb.models.Usuario;
import br.com.projetoVivere.bibliotecasb.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(UsuarioDTO usuario) {
    	Usuario novo = criarEntidade(usuario);
        return usuarioRepository.save(novo);
    }

    private Usuario criarEntidade(UsuarioDTO usuario) {
    	Usuario novo = new Usuario();
    	novo.setNome(usuario.getNome());
    	novo.setEmail(usuario.getEmail());
    	novo.setDataCadastro(Date.from(Instant.now()));
    	novo.setLogin(usuario.getLogin());
    	novo.setSenha(usuario.getSenha());
    	novo.setTelefone(usuario.getTelefone());
    	novo.setPerfil(usuario.getPerfil());
    	novo.setStatus(usuario.getStatus());
		return novo;
	}

	public Usuario editar(Usuario usuario) {
        usuario.setDataCadastro(Date.from(Instant.now()));
        return usuarioRepository.save(usuario);
    }

    public void deletarPorId(int id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    public Usuario buscarPorNome(String nome) {
        Optional<Usuario> user = usuarioRepository.findByNome(nome);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("Usuário não encontrado com nome: " + nome);
        }
        return user.get();
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}