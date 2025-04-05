package com.vertuoso.bffagendadortarefas.infrastructure.client;

import com.vertuoso.bffagendadortarefas.business.dto.in.TarefaDTORequest;
import com.vertuoso.bffagendadortarefas.business.dto.out.TarefaDTOResponse;
import com.vertuoso.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefaClient {

    @PostMapping("/tarefas")
    TarefaDTOResponse gravarTarefas(@RequestBody TarefaDTORequest dto,
                                    @RequestHeader("Authorization") String token);

    @GetMapping("/tarefas/eventos")
    List<TarefaDTOResponse> buscaListaDeTarefasPorPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
                                                          @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping("/tarefas/all")
    List<TarefaDTOResponse> buscaTarefasPorEmail(@RequestHeader(value = "Authorization", required = false) String token);

    @DeleteMapping("/tarefas/{id}")
    void deletaTarefaPorId(String id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping("/tarefas")
    TarefaDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                              @RequestParam("id") String id,
                                              @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping("/tarefas/{id}")
    TarefaDTOResponse updateTarefas(@RequestBody TarefaDTORequest dto,
                                    @RequestParam("id") String id,
                                    @RequestHeader(value = "Authorization", required = false) String token);
}