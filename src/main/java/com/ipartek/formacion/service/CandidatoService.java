package com.ipartek.formacion.service;

import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.domain.Candidato;

public interface CandidatoService extends Serializable {

	public List<Candidato> getCandidatos();

	Candidato getById(long id);

	boolean eliminar(long id);

	boolean insertar(Candidato p);

	boolean modificar(Candidato p);

}
