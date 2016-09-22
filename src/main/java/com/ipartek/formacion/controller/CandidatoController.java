package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		c.setId(1);
		c.setDni("14320765V");
		c.setNombre("Pepe");
		model.put("candidatoPepe", c);
		System.out.println(c);

		return new ModelAndView("lista-candidatos", model);

	}

	@RequestMapping(value = "/candidato/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalle(@PathVariable(value = "id") final long id) throws ServletException, IOException {

		this.logger.info("Buscando detalle del candidato con id:" + id);

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		Candidato c = new Candidato();
		c.setDni("14320765V");
		c.setNombre("Pepe");

		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		lista.add(c);
		lista.add(c);
		lista.add(c);
		lista.add(c);
		lista.add(c);

		model.put("lista", lista);

		return new ModelAndView("form", model);

	}
}
