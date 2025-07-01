package br.com.projetoVivere.bibliotecasb.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
	
    private String nome;
    private String login;
    private String senha;
    private String telefone;
    private String email;
    private String perfil;
    private String status;

}
