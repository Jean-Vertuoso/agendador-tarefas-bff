package com.vertuoso.bffagendadortarefas.business.dto.out;

import java.util.List;

public class UsuarioDTOResponse {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTOResponse> telefones;

    public UsuarioDTOResponse() {
    }

    public UsuarioDTOResponse(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<EnderecoDTOResponse> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTOResponse> enderecos) {
        this.enderecos = enderecos;
    }

    public List<TelefoneDTOResponse> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTOResponse> telefones) {
        this.telefones = telefones;
    }
}
