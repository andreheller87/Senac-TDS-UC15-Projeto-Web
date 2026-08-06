package br.senac.escolainfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "comunicado")
public class Comunicado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunicado")
    private Integer idComunicado;

    @NotBlank(message = "O título é obrigatório.")
    @Column(length = 100)
    private String titulo;

    @NotBlank(message = "A mensagem é obrigatória.")
    @Lob
    private String mensagem;

    @NotNull(message = "A data de envio é obrigatória.")
    @Column(name = "data_envio")
    private LocalDate dataEnvio;

    @JsonIgnore
    @ManyToMany(mappedBy = "comunicados")
    private List<Usuario> usuarios;

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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}