package br.senac.escolainfo.repository;

import br.senac.escolainfo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{


    Optional<Usuario> findByEmail(String email);

}