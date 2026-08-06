package br.senac.escolainfo.repository;

import br.senac.escolainfo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
