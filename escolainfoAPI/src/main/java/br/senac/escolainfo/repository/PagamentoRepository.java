package br.senac.escolainfo.repository;

import br.senac.escolainfo.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer>{

}