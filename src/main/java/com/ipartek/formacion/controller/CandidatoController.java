package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.domain.Candidato;

@Controller
public class CandidatoController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView listarCandidatos() throws ServletException, IOException {
		
		this.logger.info("Procesando petición");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		Candidato c = new Candidato();
		c.setDni("14320765V");
		c.setNombre("Pepe");
		model.put("candidatoPepe", c);
		System.out.println(c);
		
		return  new ModelAndView("lista-candidatos", model);
		
	
	}

}
