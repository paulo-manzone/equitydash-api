package com.equitydash.api.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.equitydash.api.models.Acao;

public interface AcaoRepository extends JpaRepository<Acao, Long>{

	Acao findByid(long id);
	
	@Query("SELECT a FROM Acao a WHERE (a.valor > ?1 AND a.valor < ?2)")
	List<Acao> findByInterval(Optional<BigDecimal> limInf, Optional<BigDecimal> limSup);
}
