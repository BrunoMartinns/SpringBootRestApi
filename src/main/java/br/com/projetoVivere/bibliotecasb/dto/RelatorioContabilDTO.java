package br.com.projetoVivere.bibliotecasb.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nome", "cpfCnpj", "telefone", "contabil" })
public class RelatorioContabilDTO {
	@JsonProperty("ID")
	private int id;
    private String nome;
    @JsonProperty("CPF_CNPJ")
    private String cpfCnpj;
    private String telefone;
    private List<LivrosCaixaDTO> contabil;
}
