package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.MatriculaDTO;
import br.senac.escolainfo.exception.ResourceNotFoundException;
import br.senac.escolainfo.mapper.MatriculaMapper;
import br.senac.escolainfo.model.Matricula;
import br.senac.escolainfo.repository.MatriculaRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class MatriculaService {



    private final MatriculaRepository repository;



    public MatriculaService(MatriculaRepository repository){

        this.repository = repository;

    }





    public List<MatriculaDTO> listar(){


        return repository.findAll()

                .stream()

                .map(MatriculaMapper::toDTO)

                .collect(Collectors.toList());

    }





    public MatriculaDTO buscar(Integer id){


        Matricula matricula = repository.findById(id)

                .orElseThrow(

                () -> new ResourceNotFoundException(
                        "Matrícula não encontrada com id: " + id
                )

        );


        return MatriculaMapper.toDTO(matricula);

    }





    public MatriculaDTO salvar(MatriculaDTO dto){


        Matricula matricula = MatriculaMapper.toEntity(dto);


        Matricula salva = repository.save(matricula);


        return MatriculaMapper.toDTO(salva);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }

}