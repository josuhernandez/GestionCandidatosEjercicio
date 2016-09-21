package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CandidatoController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Mostrar listado de todos los candidatos
	 *
	 * @param request
	 * @param response
	 * @return ModelAndView view: "index.jsp", model: { ArrayList
	 *         &lt;Candidato&gt; "candidatoss" , String "fecha" }
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/candidato", method = RequestMethod.GET)
	public ModelAndView listar() throws ServletException, IOException {

		this.logger.info("procesando peticion de listar candidatos...");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidatos", "pepe");
		model.put("fecha", new Date().toString());

		return new ModelAndView("candidato/index", model);
	}
}
