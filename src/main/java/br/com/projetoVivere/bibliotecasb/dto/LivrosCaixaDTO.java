package br.com.projetoVivere.bibliotecasb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LivrosCaixaDTO {

    private int id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date datalancamento;

    private String descricao;

    private String tipo;

    private float valor;

    private Integer clienteId;
    
    private float saldo;
    
}
