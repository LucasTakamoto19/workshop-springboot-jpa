package com.projetoudemy.curso.controller.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String mensagem;
    private String caminho;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String mensagem, String caminho) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
