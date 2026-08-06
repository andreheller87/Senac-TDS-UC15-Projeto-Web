package br.senac.escolainfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "certificado")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificado")
    private Integer idCertificado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_matricula", nullable = false)
    private Matricula matricula;

    @NotNull(message = "A data de emissão é obrigatória.")
    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @NotBlank(message = "O código de verificação é obrigatório.")
    @Column(name = "codigo_verificacao", length = 50)
    private String codigoVerificacao;

    // GETTERS E SETTERS

    public Integer getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(Integer idCertificado) {
        this.idCertificado = idCertificado;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public void setCodigoVerificacao(String codigoVerificacao) {
        this.codigoVerificacao = codigoVerificacao;
    }

}