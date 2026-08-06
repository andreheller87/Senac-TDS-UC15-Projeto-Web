package br.senac.escolainfo.dto;

import java.time.LocalDate;

public class ComunicadoDTO {

    private Integer idComunicado;

    private String titulo;

    private String mensagem;

    private LocalDate dataEnvio;


    public Integer getIdComunicado() {
        return idComunicado;
    }

    public void setIdComunicado(Integer idComunicado) {
        this.idComunicado = idComunicado;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}