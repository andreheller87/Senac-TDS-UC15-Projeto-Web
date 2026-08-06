package br.senac.escolainfo.service;


import br.senac.escolainfo.model.Matricula;
import br.senac.escolainfo.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MatriculaService {


    private final MatriculaRepository repository;


    public MatriculaService(MatriculaRepository repository){
        this.repository=repository;
    }



    public List<Matricula> listar(){
        return repository.findAll();
    }



    public Matricula buscar(Integer id){

        return repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Matrícula não encontrada"));
    }



    public Matricula salvar(Matricula matricula){
        return repository.save(matricula);
    }



    public void excluir(Integer id){
        repository.deleteById(id);
    }

}