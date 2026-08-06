package br.senac.escolainfo.dto;


import br.senac.escolainfo.model.Usuario.Perfil;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class UsuarioDTO {


    private Integer idUsuario;



    @NotBlank(message = "O nome é obrigatório.")
    private String nome;



    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;



    @NotBlank(message = "A senha é obrigatória.")
    private String senha;



    @NotNull(message = "O perfil é obrigatório.")
    private Perfil perfil;



    private Integer idAluno;



    private Integer idProfessor;




    // GETTERS E SETTERS


    public Integer getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }



    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }



    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }



    public Perfil getPerfil() {
        return perfil;
    }


    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }



    public Integer getIdAluno() {
        return idAluno;
    }


    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }



    public Integer getIdProfessor() {
        return idProfessor;
    }


    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

}