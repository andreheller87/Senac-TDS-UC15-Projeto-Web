package br.senac.escolainfo.mapper;


import br.senac.escolainfo.dto.PagamentoDTO;
import br.senac.escolainfo.model.Matricula;
import br.senac.escolainfo.model.Pagamento;



public class PagamentoMapper {



    public static PagamentoDTO toDTO(Pagamento pagamento){


        PagamentoDTO dto = new PagamentoDTO();



        dto.setIdPagamento(
                pagamento.getIdPagamento()
        );



        if(pagamento.getMatricula()!=null){

            dto.setIdMatricula(
                    pagamento.getMatricula().getIdMatricula()
            );

        }



        dto.setValor(
                pagamento.getValor()
        );



        dto.setDataPagamento(
                pagamento.getDataPagamento()
        );



        dto.setStatus(
                pagamento.getStatus()
        );



        return dto;

    }





    public static Pagamento toEntity(PagamentoDTO dto){


        Pagamento pagamento = new Pagamento();



        pagamento.setIdPagamento(
                dto.getIdPagamento()
        );



        if(dto.getIdMatricula()!=null){


            Matricula matricula = new Matricula();


            matricula.setIdMatricula(
                    dto.getIdMatricula()
            );


            pagamento.setMatricula(matricula);

        }



        pagamento.setValor(
                dto.getValor()
        );



        pagamento.setDataPagamento(
                dto.getDataPagamento()
        );



        pagamento.setStatus(
                dto.getStatus()
        );



        return pagamento;

    }


}