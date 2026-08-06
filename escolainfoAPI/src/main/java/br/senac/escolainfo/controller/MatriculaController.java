package br.senac.escolainfo.controller;

import br.senac.escolainfo.model.Matricula;
import br.senac.escolainfo.service.MatriculaService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin("*")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Matricula> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Matricula buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula salvar(@Valid @RequestBody Matricula matricula) {
        return service.salvar(matricula);
    }

    @PutMapping("/{id}")
    public Matricula atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Matricula matricula) {

        Matricula existente = service.buscar(id);

        existente.setAluno(matricula.getAluno());
        existente.setCurso(matricula.getCurso());
        existente.setDataMatricula(matricula.getDataMatricula());
        existente.setStatus(matricula.getStatus());

        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }

}