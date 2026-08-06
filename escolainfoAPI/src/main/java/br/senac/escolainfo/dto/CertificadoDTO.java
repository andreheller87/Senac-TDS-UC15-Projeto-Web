package br.senac.escolainfo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;



public class CertificadoDTO {


    private Integer idCertificado;


    @NotNull(message = "A matrícula é obrigatória.")
    private Integer idMatricula;



    @NotNull(message = "A data de emissão é obrigatória.")
    private LocalDate dataEmissao;



    @NotBlank(message = "O código de verificação é obrigatório.")
    private String codigoVerificacao;



    // GETTERS E SETTERS


    public Integer getIdCertificado() {
        return idCertificado;
    }


    public void setIdCertificado(Integer idCertificado) {
        this.idCertificado = idCertificado;
    }



    public Integer getIdMatricula() {
        return idMatricula;
    }


    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }



    public LocalDate getDataEmissao() {
        return dataEmissao;
    }


    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }



    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }


    public void setCodigoVerificacao(String codigoVerificacao) {
        this.codigoVerificacao = codigoVerificacao;
    }

}