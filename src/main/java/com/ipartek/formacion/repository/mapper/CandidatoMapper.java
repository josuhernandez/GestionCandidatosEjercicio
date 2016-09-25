package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Candidato;

public class CandidatoMapper implements RowMapper<Candidato> {

	@Override
	public Candidato mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Candidato c = new Candidato();
		c.setId(rs.getLong("id"));
		c.setNombre(rs.getString("nombre"));
		c.setDni(rs.getString("dni"));
		return c;
	}

}
