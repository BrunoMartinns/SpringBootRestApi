package br.com.projetoVivere.bibliotecasb.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usuario")
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="dataCadastro")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataCadastro;
	
	@Column(name="nome", nullable = false, length = 30)
	private String nome;
	
	@Column(name="login", nullable = false, unique = true, length = 15)
	private String login;
	
	@Column(name="senha", nullable = false, length = 10)
	private String senha;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email", nullable = false, length = 100)
	private String email;
	
	@Column(name="perfil", columnDefinition = "enum('A','O')", nullable = false, length = 1)
	private String perfil;
	
	@Column(name="status", columnDefinition = "enum('A','C')", nullable = false, length = 1)
	private String status;
}
