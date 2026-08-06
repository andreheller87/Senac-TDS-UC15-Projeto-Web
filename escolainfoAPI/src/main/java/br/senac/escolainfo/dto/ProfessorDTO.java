package br.senac.escolainfo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class ProfessorDTO {


    private Integer idProfessor;


    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;



    @NotBlank(message = "A disciplina é obrigatória.")
    @Size(max = 100, message = "A disciplina deve ter no máximo 100 caracteres")
    private String disciplina;



    @NotBlank(message = "O horário disponível é obrigatório.")
    @Size(max = 50, message = "O horário deve ter no máximo 50 caracteres")
    private String horarioDisponivel;



    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;



    // GETTERS E SETTERS


    public Integer getIdProfessor() {
        return idProfessor;
    }


    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }



    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getDisciplina() {
        return disciplina;
    }


    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }



    public String getHorarioDisponivel() {
        return horarioDisponivel;
    }


    public void setHorarioDisponivel(String horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

}