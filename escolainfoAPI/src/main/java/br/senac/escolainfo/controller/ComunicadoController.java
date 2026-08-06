package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.ComunicadoDTO;
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



    public ComunicadoController(ComunicadoService service){

        this.service = service;

    }





    @GetMapping
    public List<ComunicadoDTO> listar(){

        return service.listar();

    }





    @GetMapping("/{id}")
    public ComunicadoDTO buscar(
            @PathVariable Integer id
    ){

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComunicadoDTO salvar(
            @Valid @RequestBody ComunicadoDTO dto
    ){

        return service.salvar(dto);

    }





    @PutMapping("/{id}")
    public ComunicadoDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ComunicadoDTO dto
    ){


        ComunicadoDTO existente =
                service.buscar(id);



        existente.setTitulo(
                dto.getTitulo()
        );


        existente.setMensagem(
                dto.getMensagem()
        );


        existente.setDataEnvio(
                dto.getDataEnvio()
        );



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