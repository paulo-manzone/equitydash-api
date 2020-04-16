package com.equitydash.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitydash.api.models.Acao;

public interface AcaoRepository extends JpaRepository<Acao, Long>{

	Acao findByid(long id);
}
