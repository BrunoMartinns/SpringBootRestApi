package br.com.projetoVivere.bibliotecasb.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="livrosCaixa")
public class LivrosCaixa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="dataLancamento")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datalancamento;
	
	@Column(name="descricao", nullable = false, length = 50)
	private String descricao;
	
	@Column(name="tipo", columnDefinition = "enum('D','C')", nullable = false, length = 1)
	private String tipo;
	
	@Column(name="valor", nullable = false, columnDefinition = "decimal(12,2)")
	private float valor;
	
	@ManyToOne
	@JsonIgnore
	private Clientes clientes;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(Date datalancamento) {
		this.datalancamento = datalancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	
	
	public LivrosCaixa () {
		
	}

	public LivrosCaixa(Integer id, Date datalancamento, String descricao, String tipo, float valor, Clientes clientes) {
		this.id = id;
		this.datalancamento = datalancamento;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.clientes = clientes;
	}


	public LivrosCaixa(Date datalancamento, String descricao, String tipo, float valor, Clientes clientes) {
		super();
		this.datalancamento = datalancamento;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.clientes = clientes;
	}
	
	
	
	
	
	
}
