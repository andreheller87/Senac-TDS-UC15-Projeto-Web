package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.CursoDTO;
import br.senac.escolainfo.service.CursoService;


import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/cursos")
@CrossOrigin("*")
public class CursoController {



    private final CursoService service;



    public CursoController(CursoService service){

        this.service = service;

    }





    @GetMapping
    public List<CursoDTO> listar(){

        return service.listar();

    }





    @GetMapping("/{id}")
    public CursoDTO buscar(
            @PathVariable Integer id
    ){

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDTO salvar(
            @Valid @RequestBody CursoDTO cursoDTO
    ){

        return service.salvar(cursoDTO);

    }





    @PutMapping("/{id}")
    public CursoDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody CursoDTO dto
    ){


        CursoDTO existente = service.buscar(id);


        existente.setNome(dto.getNome());
        existente.setDescricao(dto.getDescricao());
        existente.setCargaHoraria(dto.getCargaHoraria());
        existente.setValor(dto.getValor());
        existente.setDataInicio(dto.getDataInicio());
        existente.setDataTermino(dto.getDataTermino());
        existente.setIdProfessor(dto.getIdProfessor());


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