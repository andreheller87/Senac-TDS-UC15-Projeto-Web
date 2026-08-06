package br.senac.escolainfo.controller;

import br.senac.escolainfo.model.Comunicado;
import br.senac.escolainfo.service.ComunicadoService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunicados")
@CrossOrigin("*")
public class ComunicadoController {

    private final ComunicadoService service;

    public ComunicadoController(ComunicadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comunicado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Comunicado buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comunicado salvar(@Valid @RequestBody Comunicado comunicado) {
        return service.salvar(comunicado);
    }

    @PutMapping("/{id}")
    public Comunicado atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Comunicado comunicado) {

        Comunicado existente = service.buscar(id);

        existente.setTitulo(comunicado.getTitulo());
        existente.setMensagem(comunicado.getMensagem());
        existente.setDataEnvio(comunicado.getDataEnvio());

        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }

}