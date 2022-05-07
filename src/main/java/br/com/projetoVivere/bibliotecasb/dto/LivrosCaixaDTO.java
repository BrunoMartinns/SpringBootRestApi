package br.com.projetoVivere.bibliotecasb.dto;

import br.com.projetoVivere.bibliotecasb.models.Clientes;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class LivrosCaixaDTO {


    private int id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date datalancamento;

    private String descricao;

    private String type;

    private float valor;

    private Integer clientes;


    public LivrosCaixaDTO(int id, Date datalancamento, String descricao, String type, float valor, Integer clientes) {
        super();
        this.id = id;
        this.datalancamento = datalancamento;
        this.descricao = descricao;
        this.type = type;
        this.valor = valor;
        this.clientes = clientes;
    }
}
