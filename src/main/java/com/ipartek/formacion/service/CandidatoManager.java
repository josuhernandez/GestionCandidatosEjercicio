package com.ipartek.formacion.service;

import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.domain.Candidato;

public interface CandidatoManager extends Serializable {

	List<Candidato> getAll();

	Candidato getById(long id);

	Candidato getByDni(long dni);

	boolean eliminar(long id);

	boolean insertar(Candidato candidato);

	boolean modificar(Candidato candidato);

}
