package br.senac.escolainfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Integer idProfessor;

    @NotBlank(message = "O nome é obrigatório.")
    @Column(length = 100)
    private String nome;

    @NotBlank(message = "A disciplina é obrigatória.")
    @Column(length = 100)
    private String disciplina;

    @NotBlank(message = "O horário disponível é obrigatório.")
    @Column(name = "horario_disponivel", length = 50)
    private String horarioDisponivel;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    @Column(length = 100)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Curso> cursos;

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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}