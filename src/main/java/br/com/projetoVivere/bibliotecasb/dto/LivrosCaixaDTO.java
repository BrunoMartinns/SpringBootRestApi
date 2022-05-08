package br.com.projetoVivere.bibliotecasb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

public class LivrosCaixaDTO {

    private int id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date datalancamento;

    private String descricao;

    private String tipo;

    private float valor;

    private Integer clientes;


    public LivrosCaixaDTO(int idLivros, Date datalancamento, String descricao, String tipo, float valor) {
        super();
        this.id = idLivros;
        this.datalancamento = datalancamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getIdLivros() {
        return id;
    }

    public void setIdLivros(int idLivros) {
        this.id = idLivros;
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

    public Integer getClientes() {
        return clientes;
    }

    public void setClientes(Integer clientes) {
        this.clientes = clientes;
    }

    public Integer getId() {
        return null;
    }
}
