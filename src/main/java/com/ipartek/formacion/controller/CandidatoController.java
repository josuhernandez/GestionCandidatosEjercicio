package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.service.CandidatoManager;

@Controller
public class CandidatoController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CandidatoManager candidatoManager;

	public void setPersonaManager(CandidatoManager candidatoManager) {
		this.candidatoManager = candidatoManager;
	}

	/**
	 * Mostrar listado de todos los candidatos
	 *
	 * 
	 * @return ModelAndView view: "index.jsp", model: { ArrayList
	 *         &lt;Candidato&gt; "candidatos" , String "fecha" }
	 * 
	 */
	@RequestMapping(value = "/candidato", method = RequestMethod.GET)
	public ModelAndView listar() throws ServletException, IOException {

		this.logger.info("procesando peticion para listar candidatos");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidatos", this.candidatoManager.getAll());
		model.put("fecha", new Date().toString());

		this.logger.info("Listados candidatos");

		return new ModelAndView("candidato/index", model);

	}

	/**
	 * Crear candidato nuevo
	 *
	 * 
	 * @return ModelAndView view: "index.jsp", model: { ArrayList
	 *         &lt;Candidato&gt; "candidatos" , String "fecha" }
	 * 
	 */
	@RequestMapping(value = "/candidato/nuevo", method = RequestMethod.GET)
	public ModelAndView crearNuevo() throws ServletException, IOException {

		this.logger.info("creando candidato nuevo");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidato", new Candidato());
		model.put("isNew", true);

		this.logger.info("creado candidato");

		return new ModelAndView("candidato/form", model);

	}

	@RequestMapping(value = "/candidato/save", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Candidato candidato, BindingResult bindingResult) {
		this.logger.trace("Salvando candidato....");

		if (bindingResult.hasErrors()) {
			this.logger.warn("parametros no validos");
			final Map<String, Object> model = new HashMap<String, Object>();
			model.put("candidato", candidato);
			return new ModelAndView("product/form", model);
		} else {

			if (candidato.isNew()) {
				this.candidatoManager.insertar(candidato);
			} else {
				this.candidatoManager.modificar(candidato);
			}
			final Map<String, Object> model = new HashMap<String, Object>();
			model.put("candidato", candidato);
			return new ModelAndView("candidato/form", model);
		}

	}

	/**
	 * Mostrar detalle candidato por id
	 *
	 * @param id
	 * 
	 * @return ModelAndView view: "index.jsp", model: { ArrayList
	 *         &lt;Candidato&gt; "candidatos" , String "fecha" }
	 * 
	 */
	@RequestMapping(value = "/candidato/mostrar/{id}", method = RequestMethod.GET)
	public ModelAndView verDetalle(@PathVariable(value = "id") final long id) {
		this.logger.trace("Mostrando detalle candidato[" + id + "]....");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", this.candidatoManager.getById(id));
		model.put("isNew", false);
		return new ModelAndView("candidato/form", model);
	}

	/**
	 * Eliminar candidato por id
	 * 
	 * @param id
	 * 
	 * @return ModelAndView view: "index.jsp", model: { ArrayList
	 *         &lt;Candidato&gt; "candidatos" , String "fecha" }
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/candidato/eliminar/{id}", method = RequestMethod.GET)
	public ModelAndView eliminar(@PathVariable(value = "id") final long id) throws ServletException, IOException {
		this.logger.trace("Eliminando candidato[" + id + "]....");

		String msg = "No eliminado candidato[" + id + "]";
		if (this.candidatoManager.eliminar(id)) {
			msg = "candidato[" + id + "] eliminado";
			this.logger.info(msg);
		} else {
			this.logger.warn(msg);
		}

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", msg);

		return new ModelAndView("candidato/index", model);
	}

	/**
	 * Mostrar detalle candidato por dni
	 *
	 * @param dni
	 * 
	 * @return ModelAndView view: "index.jsp", model: { ArrayList
	 *         &lt;Candidato&gt; "candidatos" , String "fecha" }
	 * 
	 */
	@RequestMapping(value = "/candidato/buscar/{dni}", method = RequestMethod.GET)
	public ModelAndView buscar(@PathVariable(value = "dni") final String dni) {
		this.logger.trace("Mostrando candidato[" + dni + "]....");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidatos", this.candidatoManager.getByDni(dni));
		model.put("fecha", new Date().toString());
		return new ModelAndView("product/index", model);
	}
}
