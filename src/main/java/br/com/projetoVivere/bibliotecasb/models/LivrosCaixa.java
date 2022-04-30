package br.com.projetoVivere.bibliotecasb.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LivrosCaixa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="idCliente")
	private int id_Cliente;
	
	@Column(name="dataLancamento")
	private Date datalancamento;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="tipo")
	private String type;
	
	@Column(name="valor")
	private float valor;
}
