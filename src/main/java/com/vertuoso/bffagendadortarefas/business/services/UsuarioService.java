package com.vertuoso.bffagendadortarefas.business.services;

import com.vertuoso.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.vertuoso.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.vertuoso.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.vertuoso.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import org.springframework.stereotype.Service;

import com.vertuoso.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.vertuoso.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.vertuoso.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.vertuoso.bffagendadortarefas.infrastructure.client.UsuarioClient;

@Service
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioService(UsuarioClient client) {
        this.client = client;
    }

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO usuarioDTO){
        return client.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest enderecoDTO){
        return client.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest telefoneDTO){
        return client.cadastraTelefone(telefoneDTO, token);
    }
}
