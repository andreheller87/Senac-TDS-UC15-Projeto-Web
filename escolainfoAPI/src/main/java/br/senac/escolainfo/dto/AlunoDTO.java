package br.senac.escolainfo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AlunoDTO {


    private Integer idAluno;


    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;



    @NotBlank(message = "O CPF é obrigatório")
    @Size(max = 14, message = "O CPF deve ter no máximo 14 caracteres")
    private String cpf;



    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
    private String email;



    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefone;



    @Size(max = 20, message = "O status deve ter no máximo 20 caracteres")
    private String status;



    // GETTERS E SETTERS


    public Integer getIdAluno() {
        return idAluno;
    }


    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }



    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }



    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

}