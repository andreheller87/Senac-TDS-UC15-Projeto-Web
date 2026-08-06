package br.senac.escolainfo.controller;

import br.senac.escolainfo.model.Pagamento;
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

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pagamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pagamento buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento salvar(@Valid @RequestBody Pagamento pagamento) {
        return service.salvar(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Pagamento pagamento) {

        Pagamento existente = service.buscar(id);

        existente.setMatricula(pagamento.getMatricula());
        existente.setValor(pagamento.getValor());
        existente.setDataPagamento(pagamento.getDataPagamento());
        existente.setStatus(pagamento.getStatus());

        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }

}