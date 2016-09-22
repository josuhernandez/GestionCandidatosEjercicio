package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.repository.CandidatoDAO;

@Service("candidatoManager")
public class SimpleCandidatoManager implements CandidatoManager {

	private static final long serialVersionUID = 1L;

	private List<Candidato> candidatos;

	Candidato candidato = null;

	@Autowired
	private CandidatoDAO candidatoDAOImp;

	@Override
	public List<Candidato> getAll() {
		this.candidatos = this.candidatoDAOImp.getAll();
		return this.candidatos;
	}

	@Override
	public Candidato getById(long id) {
		return this.candidatoDAOImp.getById(id);
	}

	@Override
	public Candidato getByDni(String dni) {
		return this.candidatoDAOImp.getByDni(dni);
	}

	@Override
	public boolean eliminar(long id) {
		return this.candidatoDAOImp.eliminar(id);

	}

	@Override
	public boolean insertar(Candidato candidato) {
		return this.candidatoDAOImp.insertar(candidato);
	}

	@Override
	public boolean modificar(Candidato candidato) {
		return this.candidatoDAOImp.modificar(candidato);
	}

}