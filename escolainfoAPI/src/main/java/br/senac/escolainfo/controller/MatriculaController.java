package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.MatriculaDTO;
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



    public MatriculaController(MatriculaService service){

        this.service = service;

    }





    @GetMapping
    public List<MatriculaDTO> listar(){

        return service.listar();

    }





    @GetMapping("/{id}")
    public MatriculaDTO buscar(
            @PathVariable Integer id
    ){

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatriculaDTO salvar(
            @Valid @RequestBody MatriculaDTO dto
    ){

        return service.salvar(dto);

    }





    @PutMapping("/{id}")
    public MatriculaDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody MatriculaDTO dto
    ){


        MatriculaDTO existente = service.buscar(id);


        existente.setIdAluno(dto.getIdAluno());

        existente.setIdCurso(dto.getIdCurso());

        existente.setDataMatricula(dto.getDataMatricula());

        existente.setStatus(dto.getStatus());


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