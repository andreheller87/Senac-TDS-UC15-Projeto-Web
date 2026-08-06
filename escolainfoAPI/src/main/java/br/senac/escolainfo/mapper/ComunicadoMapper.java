package br.senac.escolainfo.mapper;


import br.senac.escolainfo.dto.ComunicadoDTO;
import br.senac.escolainfo.model.Comunicado;



public class ComunicadoMapper {



    public static ComunicadoDTO toDTO(Comunicado comunicado){


        ComunicadoDTO dto = new ComunicadoDTO();



        dto.setIdComunicado(
                comunicado.getIdComunicado()
        );



        dto.setTitulo(
                comunicado.getTitulo()
        );



        dto.setMensagem(
                comunicado.getMensagem()
        );



        dto.setDataEnvio(
                comunicado.getDataEnvio()
        );



        return dto;

    }






    public static Comunicado toEntity(ComunicadoDTO dto){


        Comunicado comunicado = new Comunicado();



        comunicado.setIdComunicado(
                dto.getIdComunicado()
        );



        comunicado.setTitulo(
                dto.getTitulo()
        );



        comunicado.setMensagem(
                dto.getMensagem()
        );



        comunicado.setDataEnvio(
                dto.getDataEnvio()
        );



        return comunicado;

    }


}