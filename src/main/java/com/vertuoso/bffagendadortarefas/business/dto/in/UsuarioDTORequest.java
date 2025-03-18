package com.vertuoso.bffagendadortarefas.business.dto.in;

import java.util.List;

public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTORequest> enderecos;
    private List<TelefoneDTORequest> telefones;

    public UsuarioDTORequest() {
    }

    public UsuarioDTORequest(String nome, String email, String senha) {
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

    public List<EnderecoDTORequest> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTORequest> enderecos) {
        this.enderecos = enderecos;
    }

    public List<TelefoneDTORequest> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTORequest> telefones) {
        this.telefones = telefones;
    }
}
