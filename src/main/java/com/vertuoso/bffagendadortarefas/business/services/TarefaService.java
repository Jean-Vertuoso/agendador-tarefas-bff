package com.vertuoso.bffagendadortarefas.business.services;

import com.vertuoso.bffagendadortarefas.business.dto.in.TarefaDTORequest;
import com.vertuoso.bffagendadortarefas.business.dto.out.TarefaDTOResponse;
import com.vertuoso.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.vertuoso.bffagendadortarefas.infrastructure.client.TarefaClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaClient tarefaClient;

    public TarefaService(TarefaClient tarefaClient) {
        this.tarefaClient = tarefaClient;
    }

    public TarefaDTOResponse gravarTarefa(TarefaDTORequest tarefaDTO, String token){
        return tarefaClient.gravarTarefas(tarefaDTO, token);
    }

    public List<TarefaDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                   LocalDateTime dataFinal,
                                                                   String token){
        return tarefaClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefaDTOResponse> buscaTarefasPorEmail(String token){
        return tarefaClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token){
        tarefaClient.deletaTarefaPorId(id, token);
    }

    public TarefaDTOResponse alteraStatus(StatusNotificacaoEnum status,
                                          String id,
                                          String token){
        return tarefaClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefaDTOResponse updateTarefas(TarefaDTORequest tarefaDTO, String id, String token){
        return tarefaClient.updateTarefas(tarefaDTO, id, token);
    }
}
