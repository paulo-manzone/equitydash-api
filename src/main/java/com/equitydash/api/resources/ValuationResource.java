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
	public BigDecimal getGraham(@RequestParam String lpa, @RequestParam String vpa){
		BigDecimal llpa = new BigDecimal(lpa);
		BigDecimal lvpa = new BigDecimal(vpa);
		return BigDecimal.valueOf(Math.sqrt(22.5*llpa.doubleValue()*lvpa.doubleValue()));
	}
	
	@GetMapping("/gordon")
	public BigDecimal getGordon(@RequestParam String dividendo, @RequestParam String k, @RequestParam String g){
		BigDecimal ldividendo = new BigDecimal(dividendo);
		Float lk = Float.valueOf(k);
		Float lg = Float.valueOf(g);
		return BigDecimal.valueOf(ldividendo.doubleValue()/(lk-lg));
	}
}
