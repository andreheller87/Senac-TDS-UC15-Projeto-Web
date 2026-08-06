package br.senac.escolainfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank(message = "O nome é obrigatório.")
    @Column(length = 100)
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    @Column(length = 100)
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Column(length = 255)
    private String senha;

    @NotNull(message = "O perfil é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "aluno_id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id_professor")
    private Professor professor;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "usuario_has_comunicado",
        joinColumns = @JoinColumn(name = "usuario_id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "comunicado_id_comunicado")
    )
    private List<Comunicado> comunicados;

    public enum Perfil {
        Administrador,
        Professor,
        Aluno
    }

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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Comunicado> getComunicados() {
        return comunicados;
    }

    public void setComunicados(List<Comunicado> comunicados) {
        this.comunicados = comunicados;
    }

}