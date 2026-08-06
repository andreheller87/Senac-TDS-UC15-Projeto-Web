package br.senac.escolainfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @NotBlank(message = "O nome do curso é obrigatório.")
    @Column(length = 100)
    private String nome;

    @Lob
    private String descricao;

    @NotNull(message = "A carga horária é obrigatória.")
    @Positive(message = "A carga horária deve ser maior que zero.")
    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @NotNull(message = "O valor é obrigatório.")
    @Positive(message = "O valor deve ser maior que zero.")
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    @NotNull(message = "A data de início é obrigatória.")
    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @NotNull(message = "A data de término é obrigatória.")
    @Column(name = "data_termino")
    private LocalDate dataTermino;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

    // GETTERS E SETTERS

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}