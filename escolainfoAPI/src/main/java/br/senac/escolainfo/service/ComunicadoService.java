package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.ComunicadoDTO;
import br.senac.escolainfo.exception.ResourceNotFoundException;
import br.senac.escolainfo.mapper.ComunicadoMapper;
import br.senac.escolainfo.model.Comunicado;
import br.senac.escolainfo.repository.ComunicadoRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class ComunicadoService {



    private final ComunicadoRepository repository;



    public ComunicadoService(ComunicadoRepository repository){

        this.repository = repository;

    }





    public List<ComunicadoDTO> listar(){


        return repository.findAll()

                .stream()

                .map(ComunicadoMapper::toDTO)

                .collect(Collectors.toList());

    }





    public ComunicadoDTO buscar(Integer id){


        Comunicado comunicado = repository.findById(id)

                .orElseThrow(

                () -> new ResourceNotFoundException(
                        "Comunicado não encontrado com id: " + id
                )

        );


        return ComunicadoMapper.toDTO(comunicado);

    }





    public ComunicadoDTO salvar(ComunicadoDTO dto){


        Comunicado comunicado =
                ComunicadoMapper.toEntity(dto);



        Comunicado salvo =
                repository.save(comunicado);



        return ComunicadoMapper.toDTO(salvo);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }


}