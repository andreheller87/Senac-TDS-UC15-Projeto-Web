package br.senac.escolainfo.service;


import br.senac.escolainfo.dto.CertificadoDTO;
import br.senac.escolainfo.exception.ResourceNotFoundException;
import br.senac.escolainfo.mapper.CertificadoMapper;
import br.senac.escolainfo.model.Certificado;
import br.senac.escolainfo.repository.CertificadoRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class CertificadoService {



    private final CertificadoRepository repository;



    public CertificadoService(CertificadoRepository repository){

        this.repository = repository;

    }





    public List<CertificadoDTO> listar(){


        return repository.findAll()

                .stream()

                .map(CertificadoMapper::toDTO)

                .collect(Collectors.toList());

    }





    public CertificadoDTO buscar(Integer id){


        Certificado certificado = repository.findById(id)

                .orElseThrow(

                () -> new ResourceNotFoundException(
                        "Certificado não encontrado com id: " + id
                )

        );


        return CertificadoMapper.toDTO(certificado);

    }





    public CertificadoDTO salvar(CertificadoDTO dto){


        Certificado certificado =
                CertificadoMapper.toEntity(dto);


        Certificado salvo =
                repository.save(certificado);


        return CertificadoMapper.toDTO(salvo);

    }





    public void excluir(Integer id){

        repository.deleteById(id);

    }


}