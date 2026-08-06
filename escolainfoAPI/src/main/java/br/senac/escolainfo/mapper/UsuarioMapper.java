package br.senac.escolainfo.mapper;


import br.senac.escolainfo.dto.UsuarioDTO;
import br.senac.escolainfo.model.Aluno;
import br.senac.escolainfo.model.Professor;
import br.senac.escolainfo.model.Usuario;



public class UsuarioMapper {



    public static UsuarioDTO toDTO(Usuario usuario){


        UsuarioDTO dto = new UsuarioDTO();



        dto.setIdUsuario(
                usuario.getIdUsuario()
        );


        dto.setNome(
                usuario.getNome()
        );


        dto.setEmail(
                usuario.getEmail()
        );


        dto.setSenha(
                usuario.getSenha()
        );


        dto.setPerfil(
                usuario.getPerfil()
        );



        if(usuario.getAluno()!=null){

            dto.setIdAluno(
                    usuario.getAluno().getIdAluno()
            );

        }



        if(usuario.getProfessor()!=null){

            dto.setIdProfessor(
                    usuario.getProfessor().getIdProfessor()
            );

        }



        return dto;

    }






    public static Usuario toEntity(UsuarioDTO dto){


        Usuario usuario = new Usuario();



        usuario.setIdUsuario(
                dto.getIdUsuario()
        );


        usuario.setNome(
                dto.getNome()
        );


        usuario.setEmail(
                dto.getEmail()
        );


        usuario.setSenha(
                dto.getSenha()
        );


        usuario.setPerfil(
                dto.getPerfil()
        );




        if(dto.getIdAluno()!=null){


            Aluno aluno = new Aluno();


            aluno.setIdAluno(
                    dto.getIdAluno()
            );


            usuario.setAluno(aluno);

        }




        if(dto.getIdProfessor()!=null){


            Professor professor = new Professor();


            professor.setIdProfessor(
                    dto.getIdProfessor()
            );


            usuario.setProfessor(professor);

        }



        return usuario;

    }


}