package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.AlunoDTO;
import br.senac.escolainfo.mapper.AlunoMapper;
import br.senac.escolainfo.model.Aluno;
import br.senac.escolainfo.repository.AlunoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AlunoService {


    private final AlunoRepository repository;


    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }



    public List<AlunoDTO> listar(){


        return repository.findAll()
                .stream()
                .map(AlunoMapper::toDTO)
                .collect(Collectors.toList());

    }





    public AlunoDTO buscar(Integer id){


        Aluno aluno = repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Aluno não encontrado")
                );


        return AlunoMapper.toDTO(aluno);

    }





    public AlunoDTO salvar(AlunoDTO dto){


        Aluno aluno = AlunoMapper.toEntity(dto);


        Aluno salvo = repository.save(aluno);


        return AlunoMapper.toDTO(salvo);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }


}