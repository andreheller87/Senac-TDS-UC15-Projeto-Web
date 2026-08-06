package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.UsuarioDTO;
import br.senac.escolainfo.service.UsuarioService;


import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {



    private final UsuarioService service;



    public UsuarioController(UsuarioService service){

        this.service = service;

    }





    @GetMapping
    public List<UsuarioDTO> listar(){

        return service.listar();

    }





    @GetMapping("/{id}")
    public UsuarioDTO buscar(
            @PathVariable Integer id
    ){

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO salvar(
            @Valid @RequestBody UsuarioDTO dto
    ){

        return service.salvar(dto);

    }





    @PutMapping("/{id}")
    public UsuarioDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody UsuarioDTO dto
    ){


        UsuarioDTO existente =
                service.buscar(id);



        existente.setNome(dto.getNome());

        existente.setEmail(dto.getEmail());

        existente.setSenha(dto.getSenha());

        existente.setPerfil(dto.getPerfil());

        existente.setIdAluno(dto.getIdAluno());

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