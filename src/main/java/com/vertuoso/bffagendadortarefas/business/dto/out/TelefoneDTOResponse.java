package com.vertuoso.bffagendadortarefas.business.dto.out;

public class TelefoneDTOResponse {

    private Long id;
    private String ddd;
    private String numero;

    public TelefoneDTOResponse() {
    }

    public TelefoneDTOResponse(String ddd, String numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
