package br.senac.escolainfo.exception;

import java.time.LocalDateTime;

public class ErrorResponse {


    private LocalDateTime data;

    private Integer status;

    private String erro;

    private String mensagem;



    public ErrorResponse(
            LocalDateTime data,
            Integer status,
            String erro,
            String mensagem
    ){

        this.data = data;
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;

    }



    public LocalDateTime getData() {
        return data;
    }


    public Integer getStatus() {
        return status;
    }


    public String getErro() {
        return erro;
    }


    public String getMensagem() {
        return mensagem;
    }

}