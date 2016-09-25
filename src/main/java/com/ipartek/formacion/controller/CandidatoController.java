package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.service.CandidatoServiceImpl;

@Controller
public class CandidatoController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired  // enlazamos el controller con el servicio
	private CandidatoServiceImpl candidatoServiceImpl;

	
	
	/**
	 * Método que nos muestra un formulario vacio para crear un nuevo Candidato
	 * @return ModelAndView   
	 */
	@RequestMapping(value = "/candidato/nuevo", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioVacio() {
		
		this.logger.info("Mostrando formulario vacio para crear nuevo candidato.....");
		
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidato", new Candidato());
		model.put("isNew", true);

		this.logger.info("Formulario mostrado");
		
		return new ModelAndView("/candidato/form", model);

	}
	
	
	/**
	 * Método  que crea un nuevo Candidato o lo modifica en funcion de si es nuevo o ya existe
	 * @return ModelAndView   Map&lt;String, Object&gt; con la lista de candidatos 
	 * 						y la fecha cuando de ha producido el cambio.
	 */
	@RequestMapping(value = "/candidato/save", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Candidato candidato, BindingResult bindingResult) {
		
		this.logger.trace("Salvando candidato....");
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		String view = "/candidato/form";

		if (bindingResult.hasErrors()) {
			this.logger.warn("Parametros no validos");
			model.put("isNew", candidato.isNew());
		} else {
			if (candidato.isNew()) {
				this.candidatoServiceImpl.insertar(candidato);
			} else {
				this.candidatoServiceImpl.modificar(candidato);
			}
			
			model.put("msg", "Candidato guardado con exito");
			model.put("listaCandidatos", this.candidatoServiceImpl.getCandidatos());
			model.put("fecha", new Date().toString());
			view = "/candidato/lista-candidatos";
		}
		return new ModelAndView(view, model);
	}
	
	
	
	/**
	 * Método para obtener el listado de los candidatos
	 * @return ModelAndView  Map&lt;String, Object&gt; con la lista de candidatos 
	 * 						y la fecha cuando de ha producido el cambio.
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView listarCandidatos() throws ServletException, IOException {

		this.logger.info("Procesando petición de listado candidatos");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("listaCandidatos", this.candidatoServiceImpl.getCandidatos());
		model.put("fecha", new Date().toString());

		return new ModelAndView("candidato/lista-candidatos", model);
	}
	

	/**
	 * Método para obtener el detalle del candidato con un determinado 'id'
	 * @param id  id del candidato a buscar
	 * @return ModelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/candidato/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleCandidato(@PathVariable(value = "id") final long id) throws ServletException, IOException {

		this.logger.info("Buscando detalle del candidato con id:" + id + " .....");
		

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("candidato", this.candidatoServiceImpl.getById(id));

		
		// atributos == modelo
		/*final Map<String, Object> model = new HashMap<String, Object>();
		Candidato c = new Candidato();
		c.setDni("14320765V");
		c.setNombre("Pepe");

		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		lista.add(c);
		lista.add(c);
		lista.add(c);
		lista.add(c);
		lista.add(c);

		model.put("lista", lista);*/

		return new ModelAndView("candidato/form", model);
	}
	
	/**
	 * Método para eliminar el candidato con un determinado 'id'
	 * @param id  id del candidato a buscar
	 * @return ModelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/candidato/eliminar/{id}", method = RequestMethod.GET)
	public ModelAndView eliminar(@PathVariable(value = "id") final long id) throws ServletException, IOException {
		this.logger.trace("Eliminando candidato[" + id + "]....");

		String msg = "No eliminado candidato[" + id + "]";
		if (this.candidatoServiceImpl.eliminar(id)) {
			msg = "Candidato[" + id + "] eliminado";
			this.logger.info(msg);
		} else {
			this.logger.warn(msg);
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", msg);
		model.put("listaCandidatos", this.candidatoServiceImpl.getCandidatos());

		return new ModelAndView("candidato/lista-candidatos", model);
	}
	
	
	/**
	 * Método para modificar un candidato con un determinado 'id'
	 * @param id  id del candidato a buscar
	 * @return ModelAndView  view: "form.jsp", model: { ArrayList
	 *         &lt;Candidato&gt; "candidato" , Boolean "isNew" }
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/candidato/modificar/{id}", method = RequestMethod.GET)
	public ModelAndView modificar(@PathVariable(value = "id") final long id) throws ServletException, IOException {
		
		this.logger.trace("Mostrar vista para modificar candidato con id:" + id + "....");

		Candidato cDetalle = candidatoServiceImpl.getById(id);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidato", cDetalle);
		model.put("isNew", false);

		return new ModelAndView("candidato/form", model);
	}

}



