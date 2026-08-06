package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.CursoDTO;
import br.senac.escolainfo.exception.ResourceNotFoundException;
import br.senac.escolainfo.mapper.CursoMapper;
import br.senac.escolainfo.model.Curso;
import br.senac.escolainfo.repository.CursoRepository;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class CursoService {



    private final CursoRepository repository;



    public CursoService(CursoRepository repository){

        this.repository = repository;

    }




    public List<CursoDTO> listar(){


        return repository.findAll()
                .stream()
                .map(CursoMapper::toDTO)
                .collect(Collectors.toList());

    }





    public CursoDTO buscar(Integer id){


        Curso curso = repository.findById(id)

                .orElseThrow(

                () -> new ResourceNotFoundException(
                        "Curso não encontrado com id: " + id
                )

        );


        return CursoMapper.toDTO(curso);

    }





    public CursoDTO salvar(CursoDTO dto){


        Curso curso = CursoMapper.toEntity(dto);


        Curso salvo = repository.save(curso);


        return CursoMapper.toDTO(salvo);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }


}