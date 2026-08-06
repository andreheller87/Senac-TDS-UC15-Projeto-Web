package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.ProfessorDTO;
import br.senac.escolainfo.service.ProfessorService;


import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/professores")
@CrossOrigin("*")
public class ProfessorController {



    private final ProfessorService service;



    public ProfessorController(ProfessorService service){

        this.service = service;

    }





    @GetMapping
    public List<ProfessorDTO> listar(){

        return service.listar();

    }





    @GetMapping("/{id}")
    public ProfessorDTO buscar(
            @PathVariable Integer id
    ){

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO salvar(
            @Valid @RequestBody ProfessorDTO professorDTO
    ){

        return service.salvar(professorDTO);

    }





    @PutMapping("/{id}")
    public ProfessorDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ProfessorDTO dto
    ){


        ProfessorDTO existente = service.buscar(id);


        existente.setNome(dto.getNome());

        existente.setDisciplina(dto.getDisciplina());

        existente.setHorarioDisponivel(dto.getHorarioDisponivel());

        existente.setEmail(dto.getEmail());


        return service.salvar(existente);

    }





    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Integer id
    ){

        service.excluir(id);

    }


}