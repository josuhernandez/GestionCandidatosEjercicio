package com.ipartek.formacion.repository;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Candidato;

public interface CandidatoDAO extends Serializable {

	List<Candidato> getCandidato();

	Candidato getById(long id);

	boolean eliminar(long id);

	boolean insertar(Candidato p);

	boolean modificar(Candidato p);

	void setDataSource(DataSource dataSource);

}
