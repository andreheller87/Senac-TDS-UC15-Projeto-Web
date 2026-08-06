package br.senac.escolainfo.mapper;


import br.senac.escolainfo.dto.CertificadoDTO;
import br.senac.escolainfo.model.Certificado;
import br.senac.escolainfo.model.Matricula;



public class CertificadoMapper {



    public static CertificadoDTO toDTO(Certificado certificado){


        CertificadoDTO dto = new CertificadoDTO();


        dto.setIdCertificado(
                certificado.getIdCertificado()
        );


        if(certificado.getMatricula()!=null){

            dto.setIdMatricula(
                    certificado.getMatricula().getIdMatricula()
            );

        }


        dto.setDataEmissao(
                certificado.getDataEmissao()
        );


        dto.setCodigoVerificacao(
                certificado.getCodigoVerificacao()
        );


        return dto;

    }





    public static Certificado toEntity(CertificadoDTO dto){


        Certificado certificado = new Certificado();


        certificado.setIdCertificado(
                dto.getIdCertificado()
        );



        if(dto.getIdMatricula()!=null){


            Matricula matricula = new Matricula();


            matricula.setIdMatricula(
                    dto.getIdMatricula()
            );


            certificado.setMatricula(matricula);

        }



        certificado.setDataEmissao(
                dto.getDataEmissao()
        );



        certificado.setCodigoVerificacao(
                dto.getCodigoVerificacao()
        );


        return certificado;

    }


}