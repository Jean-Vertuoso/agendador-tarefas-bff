package com.vertuoso.bffagendadortarefas.infrastructure.client.config;

import com.vertuoso.bffagendadortarefas.infrastructure.exceptions.BusinessException;
import com.vertuoso.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import com.vertuoso.bffagendadortarefas.infrastructure.exceptions.IllegalArgumentException;
import com.vertuoso.bffagendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.vertuoso.bffagendadortarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        String mensagemErro = mensagemErro(response);

        return switch (response.status()) {
            case 409 -> new ConflictException("Erro: " + mensagemErro);
            case 403 -> new ResourceNotFoundException("Erro: " + mensagemErro);
            case 401 -> new UnauthorizedException("Erro: " + mensagemErro);
            case 400 -> new IllegalArgumentException("Erro: " + mensagemErro);
            default -> new BusinessException("Erro: " + mensagemErro);
        };
    }

    private String mensagemErro(Response response){
        try {
            if(Objects.isNull(response.body())){
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
