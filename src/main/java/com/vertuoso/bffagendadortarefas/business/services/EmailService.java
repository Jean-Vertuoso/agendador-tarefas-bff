package com.vertuoso.bffagendadortarefas.business.services;

import com.vertuoso.bffagendadortarefas.business.dto.out.TarefaDTOResponse;
import com.vertuoso.bffagendadortarefas.infrastructure.client.EmailClient;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailClient emailClient;

    public EmailService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void enviaEmail(TarefaDTOResponse dto){
        emailClient.enviarEmail(dto);
    }
}
