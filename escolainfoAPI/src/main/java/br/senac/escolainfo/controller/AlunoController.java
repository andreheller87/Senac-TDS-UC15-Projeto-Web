package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.AlunoDTO;
import br.senac.escolainfo.service.AlunoService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*")
public class AlunoController {



    private final AlunoService service;



    public AlunoController(AlunoService service) {
        this.service = service;
    }





    @GetMapping
    public List<AlunoDTO> listar() {

        return service.listar();

    }





    @GetMapping("/{id}")
    public AlunoDTO buscar(
            @PathVariable Integer id
    ) {

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO salvar(
            @Valid @RequestBody AlunoDTO alunoDTO
    ) {

        return service.salvar(alunoDTO);

    }





    @PutMapping("/{id}")
    public AlunoDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody AlunoDTO alunoDTO
    ) {


        AlunoDTO existente = service.buscar(id);


        existente.setNome(alunoDTO.getNome());

        existente.setCpf(alunoDTO.getCpf());

        existente.setEmail(alunoDTO.getEmail());

        existente.setTelefone(alunoDTO.getTelefone());

        existente.setStatus(alunoDTO.getStatus());



        return service.salvar(existente);

    }





    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Integer id
    ) {

        service.excluir(id);

    }


}