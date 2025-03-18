package com.vertuoso.bffagendadortarefas.infrastructure.client;

import com.vertuoso.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.vertuoso.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.vertuoso.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.vertuoso.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.vertuoso.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.vertuoso.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.vertuoso.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping("/usuario")
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/usuario/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);

    @DeleteMapping("/usuario/{email}")
    Void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping("/usuario")
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);
}