package com.equitydash.api.resources;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.equitydash.api.repository.AcaoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.equitydash.api.models.Acao;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="Rest API Equitydash")
public class AcaoResource {
	
	@Autowired
	AcaoRepository acaoRepository;
	
	@ApiOperation(value="Retorna uma ação específica com base no id fornecido")
	@GetMapping("/acoes")
	public List<Acao> acaoPorIntervalo(@RequestParam Optional<BigDecimal> limInf, @RequestParam Optional<BigDecimal> limSup ){
		if(limInf.isPresent() && limSup.isPresent()) return acaoRepository.findByInterval(limInf, limSup);
		else return acaoRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma ação específica com base no id fornecido")
	@GetMapping("/acoes/{id}")
	public Optional<Acao> acaoPorId(@PathVariable(value="id") long id){
		return acaoRepository.findById(id);
	}
	
	
	@ApiOperation(value="Cadastra uma nova ação")
	@PostMapping("/acoes")
	public Acao insereAcao(@RequestBody Acao acao) {
		return acaoRepository.save(acao);
	}
	
	@ApiOperation(value="Exclui uma ação")
	@DeleteMapping("/acoes")
	public void deletaAcao(@RequestBody Acao acao) {
		acaoRepository.delete(acao);
	}
	
	@ApiOperation(value="Atualiza uma ação")
	@PutMapping("/acoes")
	public Acao atualizaAcao(@RequestBody Acao acao) {
		return acaoRepository.save(acao);
	}

}
