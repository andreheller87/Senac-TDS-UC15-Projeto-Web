package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.ProfessorDTO;
import br.senac.escolainfo.exception.ResourceNotFoundException;
import br.senac.escolainfo.mapper.ProfessorMapper;
import br.senac.escolainfo.model.Professor;
import br.senac.escolainfo.repository.ProfessorRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class ProfessorService {



    private final ProfessorRepository repository;



    public ProfessorService(ProfessorRepository repository){

        this.repository = repository;

    }





    public List<ProfessorDTO> listar(){


        return repository.findAll()

                .stream()

                .map(ProfessorMapper::toDTO)

                .collect(Collectors.toList());

    }





    public ProfessorDTO buscar(Integer id){


        Professor professor = repository.findById(id)

                .orElseThrow(

                () -> new ResourceNotFoundException(
                        "Professor não encontrado com id: " + id
                )

        );


        return ProfessorMapper.toDTO(professor);

    }





    public ProfessorDTO salvar(ProfessorDTO dto){


        Professor professor = ProfessorMapper.toEntity(dto);


        Professor salvo = repository.save(professor);


        return ProfessorMapper.toDTO(salvo);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }


}