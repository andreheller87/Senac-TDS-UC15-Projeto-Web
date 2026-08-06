package br.senac.escolainfo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class MatriculaDTO {


    private Integer idMatricula;


    @NotNull(message = "O aluno é obrigatório.")
    private Integer idAluno;



    @NotNull(message = "O curso é obrigatório.")
    private Integer idCurso;



    @NotNull(message = "A data da matrícula é obrigatória.")
    private LocalDate dataMatricula;



    @NotBlank(message = "O status é obrigatório.")
    private String status;



    // GETTERS E SETTERS


    public Integer getIdMatricula() {
        return idMatricula;
    }


    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }



    public Integer getIdAluno() {
        return idAluno;
    }


    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }



    public Integer getIdCurso() {
        return idCurso;
    }


    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }



    public LocalDate getDataMatricula() {
        return dataMatricula;
    }


    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }



    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

}