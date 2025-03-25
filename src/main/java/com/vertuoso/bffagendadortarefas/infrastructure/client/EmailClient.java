package com.vertuoso.bffagendadortarefas.infrastructure.client;

import com.vertuoso.bffagendadortarefas.business.dto.out.TarefaDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefaDTOResponse tarefaDTO);
}
