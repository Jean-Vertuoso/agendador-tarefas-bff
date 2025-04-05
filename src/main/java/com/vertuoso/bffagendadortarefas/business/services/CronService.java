package com.vertuoso.bffagendadortarefas.business.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vertuoso.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.vertuoso.bffagendadortarefas.business.dto.out.TarefaDTOResponse;
import com.vertuoso.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CronService {

    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;
    private static final Logger log = LoggerFactory.getLogger(CronService.class);

    public CronService(TarefaService tarefaService, EmailService emailService, UsuarioService usuarioService) {
        this.tarefaService = tarefaService;
        this.emailService = emailService;
        this.usuarioService = usuarioService;
    }

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora(){
        String token = login(converterParaRequestDTO());
        StatusNotificacaoEnum notificado = StatusNotificacaoEnum.NOTIFICADO;
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List<TarefaDTOResponse> listaTarefas = tarefaService.buscaTarefasAgendadasPorPeriodo(horaFutura, horaFuturaMaisCinco, token);

        log.info("Tarefas encontradas " + listaTarefas);
        listaTarefas.forEach(tarefa -> {
                                emailService.enviaEmail(tarefa);
                                log.info("Email enviado para o usuário " + tarefa.getEmailUsuario());
                                tarefaService.alteraStatus(notificado, tarefa.getId(), token);
        });
        log.info("Finalizada a busca e notificação de tarefas");
    }

    public String login(LoginRequestDTO dto){
        return usuarioService.loginUsuario(dto);
    }

    public LoginRequestDTO converterParaRequestDTO(){
        LoginRequestDTO dto = new LoginRequestDTO();
        dto.setEmail(email);
        dto.setSenha(senha);

        return dto;
    }
}
