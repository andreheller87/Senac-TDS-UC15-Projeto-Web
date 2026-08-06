package br.senac.escolainfo.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;


public class PagamentoDTO {


    private Integer idPagamento;


    @NotNull(message = "A matrícula é obrigatória.")
    private Integer idMatricula;



    @NotNull(message = "O valor é obrigatório.")
    @Positive(message = "O valor deve ser maior que zero.")
    private BigDecimal valor;



    @NotNull(message = "A data do pagamento é obrigatória.")
    private LocalDate dataPagamento;



    @NotNull(message = "O status é obrigatório.")
    private String status;



    // GETTERS E SETTERS


    public Integer getIdPagamento() {
        return idPagamento;
    }


    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }



    public Integer getIdMatricula() {
        return idMatricula;
    }


    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }



    public BigDecimal getValor() {
        return valor;
    }


    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }



    public LocalDate getDataPagamento() {
        return dataPagamento;
    }


    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }



    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

}