package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.repository.CandidatoDAO;

@Service("candidatoServiceImpl")
public class CandidatoServiceImpl implements CandidatoService {

	@Autowired // ligamos el servicio con el DAO
	private CandidatoDAO candidatoDAOImpl;
	
	private List<Candidato> candidatos;
	
	/**
	 * Método que llama al método 'getCandidatos()' de la implementación del DAO 
	 * para obtener una lista con todos los candidatos
	 * @return List<Candidato>   lista de objetos tipo Candidato 
	 */
	@Override
	public List<Candidato> getCandidatos() {
		this.candidatos = this.candidatoDAOImpl.getCandidatos();
		return this.candidatos;
	}

	
	/**
	 * Método que llama al método 'getById()' de la implementación del DAO 
	 * para obtener los datos del candidato con id='id'
	 * @param id   {@code long} id del candidato
	 * @return Candidato   
	 */
	@Override
	public Candidato getById(long id) {
		return this.candidatoDAOImpl.getById(id);
	}

	/**
	 * Método que llama al método 'eliminar()' de la implementación del DAO 
	 * para elimnar el candidato con id='id'
	 * @param id   {@code long} id del candidato
	 * @return boolean   
	 */
	@Override
	public boolean eliminar(long id) {
		return this.candidatoDAOImpl.eliminar(id);
	}

	
	/**
	 * Método que llama al método 'insertar()' de la implementación del DAO 
	 * para crear un nuevo candidato en la BBDD
	 * @param c   {@code pojo Candidato} id del candidato
	 * @return boolean
	 */
	@Override
	public boolean insertar(Candidato c) {
		return this.candidatoDAOImpl.insertar(c);
	}

	
	/**
	 * Método que llama al método 'modificar()' de la implementación del DAO 
	 * para modificar un candidato
	 * @param c   {@code pojo Candidato} id del candidato
	 * @return boolean
	 */
	@Override
	public boolean modificar(Candidato c) {
		return this.candidatoDAOImpl.modificar(c);
	}

}
