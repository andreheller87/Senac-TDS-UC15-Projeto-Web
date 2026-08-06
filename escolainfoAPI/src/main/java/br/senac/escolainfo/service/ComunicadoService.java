package br.senac.escolainfo.service;


import br.senac.escolainfo.model.Comunicado;
import br.senac.escolainfo.repository.ComunicadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComunicadoService {


    private final ComunicadoRepository repository;


    public ComunicadoService(ComunicadoRepository repository){
        this.repository=repository;
    }



    public List<Comunicado> listar(){
        return repository.findAll();
    }



    public Comunicado buscar(Integer id){

        return repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Comunicado não encontrado"));
    }



    public Comunicado salvar(Comunicado comunicado){
        return repository.save(comunicado);
    }



    public void excluir(Integer id){
        repository.deleteById(id);
    }

}