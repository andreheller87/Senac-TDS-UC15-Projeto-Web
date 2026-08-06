package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.CertificadoDTO;
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



    public CertificadoController(CertificadoService service){

        this.service = service;

    }





    @GetMapping
    public List<CertificadoDTO> listar(){

        return service.listar();

    }





    @GetMapping("/{id}")
    public CertificadoDTO buscar(
            @PathVariable Integer id
    ){

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CertificadoDTO salvar(
            @Valid @RequestBody CertificadoDTO dto
    ){

        return service.salvar(dto);

    }





    @PutMapping("/{id}")
    public CertificadoDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody CertificadoDTO dto
    ){


        CertificadoDTO existente =
                service.buscar(id);



        existente.setIdMatricula(
                dto.getIdMatricula()
        );


        existente.setDataEmissao(
                dto.getDataEmissao()
        );


        existente.setCodigoVerificacao(
                dto.getCodigoVerificacao()
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