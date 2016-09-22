package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Candidato;

public class CandidatoManagerImpl implements CandidatoManager {

	private static final long serialVersionUID = 1L;

	private List<Candidato> candidatos;

	@Override
	public List<Candidato> getAll() {
		return this.candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	@Override
	public Candidato getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidato getByDni(long dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertar(Candidato candidato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Candidato candidato) {
		// TODO Auto-generated method stub
		return false;
	}

}
