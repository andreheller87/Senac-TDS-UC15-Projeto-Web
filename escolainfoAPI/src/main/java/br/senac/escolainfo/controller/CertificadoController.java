package br.senac.escolainfo.controller;

import br.senac.escolainfo.model.Certificado;
import br.senac.escolainfo.service.CertificadoService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificados")
@CrossOrigin("*")
public class CertificadoController {

    private final CertificadoService service;

    public CertificadoController(CertificadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Certificado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Certificado buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Certificado salvar(@Valid @RequestBody Certificado certificado) {
        return service.salvar(certificado);
    }

    @PutMapping("/{id}")
    public Certificado atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Certificado certificado) {

        Certificado existente = service.buscar(id);

        existente.setMatricula(certificado.getMatricula());
        existente.setDataEmissao(certificado.getDataEmissao());
        existente.setCodigoVerificacao(certificado.getCodigoVerificacao());

        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }

}