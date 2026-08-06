package br.senac.escolainfo.service;


import br.senac.escolainfo.model.Pagamento;
import br.senac.escolainfo.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PagamentoService {


    private final PagamentoRepository repository;


    public PagamentoService(PagamentoRepository repository){
        this.repository=repository;
    }



    public List<Pagamento> listar(){
        return repository.findAll();
    }



    public Pagamento buscar(Integer id){

        return repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Pagamento não encontrado"));
    }



    public Pagamento salvar(Pagamento pagamento){
        return repository.save(pagamento);
    }



    public void excluir(Integer id){
        repository.deleteById(id);
    }

}