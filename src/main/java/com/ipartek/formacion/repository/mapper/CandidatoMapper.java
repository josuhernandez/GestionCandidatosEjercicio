package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Candidato;

public class CandidatoMapper implements RowMapper<Candidato> {

	@Override
	public Candidato mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Candidato candidato = new Candidato();
		candidato.setId(rs.getLong("id"));
		candidato.setDni(rs.getString("dni"));
		candidato.setNombre(rs.getString("nombre"));
		return candidato;
	}

}
