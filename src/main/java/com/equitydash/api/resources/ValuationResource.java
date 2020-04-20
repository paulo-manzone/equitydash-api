package com.equitydash.api.resources;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/valuation")
@Api(value="Valuation API")
public class ValuationResource {
	
	@GetMapping("/graham")
	public BigDecimal getGraham(@RequestParam BigDecimal lpa, @RequestParam BigDecimal vpa){
		return BigDecimal.valueOf(Math.sqrt(22.5*lpa.doubleValue()*vpa.doubleValue()));
	}
	
	@GetMapping("/gordon")
	public BigDecimal getGordon(@RequestParam BigDecimal dividendo, @RequestParam float k, @RequestParam float g){
		return BigDecimal.valueOf(dividendo.doubleValue()/(k-g));
	}
}
