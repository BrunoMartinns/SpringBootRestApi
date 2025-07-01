package br.com.projetoVivere.bibliotecasb.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dataCadastro")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataCadastro;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "cpfCnpj", nullable = false, length = 12)
	private String cpfCnpj;
	
	@Column(name = "logradouro", nullable = false, length = 50)
	private String logradouro;
	
	@Column(name = "cidade", nullable = false, length = 20)
	private String cidade;
	
	@Column(name = "uf", nullable = false, length = 2)
	private String uf;
	
	@Column(name = "cep", nullable = false, length = 8)
	private String cep;
	
	@Column(name = "telefone", nullable = false, length = 11)
	private String telefone;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;	

}
