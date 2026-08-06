package br.senac.escolainfo.controller;


import br.senac.escolainfo.dto.PagamentoDTO;
import br.senac.escolainfo.service.PagamentoService;


import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/pagamentos")
@CrossOrigin("*")
public class PagamentoController {



    private final PagamentoService service;



    public PagamentoController(PagamentoService service){

        this.service = service;

    }





    @GetMapping
    public List<PagamentoDTO> listar(){

        return service.listar();

    }





    @GetMapping("/{id}")
    public PagamentoDTO buscar(
            @PathVariable Integer id
    ){

        return service.buscar(id);

    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoDTO salvar(
            @Valid @RequestBody PagamentoDTO dto
    ){

        return service.salvar(dto);

    }





    @PutMapping("/{id}")
    public PagamentoDTO atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody PagamentoDTO dto
    ){


        PagamentoDTO existente = service.buscar(id);


        existente.setIdMatricula(dto.getIdMatricula());

        existente.setValor(dto.getValor());

        existente.setDataPagamento(dto.getDataPagamento());

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