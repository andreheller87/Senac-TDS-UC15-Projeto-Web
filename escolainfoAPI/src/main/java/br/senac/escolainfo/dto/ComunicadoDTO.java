package br.senac.escolainfo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;



public class ComunicadoDTO {



    private Integer idComunicado;



    @NotBlank(message = "O título é obrigatório.")
    private String titulo;



    @NotBlank(message = "A mensagem é obrigatória.")
    private String mensagem;



    @NotNull(message = "A data de envio é obrigatória.")
    private LocalDate dataEnvio;




    // GETTERS E SETTERS


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