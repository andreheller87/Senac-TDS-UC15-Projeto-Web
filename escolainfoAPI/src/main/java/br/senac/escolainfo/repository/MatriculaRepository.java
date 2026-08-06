package br.senac.escolainfo.repository;

import br.senac.escolainfo.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula,Integer>{

}