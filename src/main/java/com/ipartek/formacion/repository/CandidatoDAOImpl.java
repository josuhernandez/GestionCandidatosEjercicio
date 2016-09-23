package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Candidato;

@Repository("candidatoDAOImpl")
public class CandidatoDAOImpl implements CandidatoDAO {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CandidatoDAOImpl.class);

	@Autowired
	private DataSource dataSource = null;

	private JdbcTemplate jdbctemplate = null;
	private SimpleJdbcCall jdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);
	}

	@Override
	public List<Candidato> getCandidato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidato getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertar(Candidato p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Candidato p) {
		// TODO Auto-generated method stub
		return false;
	}

}
