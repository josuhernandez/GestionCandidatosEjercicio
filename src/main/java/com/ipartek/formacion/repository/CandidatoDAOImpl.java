package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.repository.mapper.CandidatoMapper;
import com.mysql.jdbc.Statement;

@Repository("candidatoDAOImpl")
public class CandidatoDAOImpl implements CandidatoDAO {

	private static final long serialVersionUID = 1L;
	private final Log logger = LogFactory.getLog(getClass());

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

	
	/**
	 * Método para obtener de la BBDD una lista de todos los candidatos
	 * @return Lista<Candidato>  lista de objetos del tipo Candidato
	 * 
	 */
	@Override
	public List<Candidato> getCandidatos() {
		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		final String SQL = "SELECT id, nombre, dni FROM candidate;";

		try {
			lista = (ArrayList<Candidato>) this.jdbctemplate.query(SQL, new CandidatoMapper());
		} catch (final EmptyResultDataAccessException e) {
			logger.warn("NO existen candidatos todavia" + SQL);
		} catch (final Exception e) {

		}
		return lista;
	}

	/**
	 * Método para obtener de la BBDD los detalles del candidato con id='id'
	 * @param id     id del candidato
	 * @return Candidato
	 */
	@Override
	public Candidato getById(long id) {
		Candidato c = new Candidato();
		final String SQL = "SELECT id, nombre, dni FROM candidate WHERE id=" + id;
		
		try{
			c = this.jdbctemplate.queryForObject(SQL, new CandidatoMapper());
		}catch(EmptyResultDataAccessException e){
			logger.warn("No existe candidato con el ID=" + id);
			c = null;
		}catch (Exception e) {
			logger.error(e.getMessage());
			c = null;
		}
		
		return c;
	}

	
	/**
	 * Método para eliminar de la BBDD el candidato con id='id'
	 * @param id     id del candidato
	 * @return boolean  'true' si se ha eliminado correctamente
	 */
	@Override
	public boolean eliminar(long id) {
		boolean resul = false;
		// TODO preparedStatement
		final String SQL = "DELETE FROM `candidate` WHERE  `id`=" + id;

		if (1 == this.jdbctemplate.update(SQL)) {
			resul = true;
		}

		return resul;
	}

	
	/**
	 * Método para insertar un nuevo candidato en la BBDD
	 * @param c	 {@code}Candidato     
	 * @return boolean  'true' si el número de filas afectadas es 1
	 * 					'false' si es distinto de 1
	 */
	@Override
	public boolean insertar(final Candidato c) {
		boolean resul = false;
		int affectedRows = -1;
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sqlInsert = "INSERT INTO `candidate` (  `nombre`, `dni`) VALUES ( ? , ?  );";
		affectedRows = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				final PreparedStatement ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, c.getNombre());
				ps.setString(2, c.getDni());
				return ps;
			}
		}, keyHolder);

		if (affectedRows == 1) {
			resul = true;
			c.setId(keyHolder.getKey().longValue());
			logger.trace("Candidato creado OK");
		}

		return resul;
	}



	/**
	 * Método para modificar en la BBDD el candidato con id='id'
	 * @param c	 {@code}Candidato     
	 * @return boolean  'true' si el número de filas afectadas es 1
	 * 					'false' si es distinto de 1
	 */
	@Override
	public boolean modificar(Candidato c) {
		final String SQL = "UPDATE `candidate` SET `nombre`=? , `dni`=? WHERE  `id`=?;";
		Object[] arguments = { c.getNombre(), c.getDni(), c.getId() };
		int affectedRows = this.jdbctemplate.update(SQL, arguments);
		return (affectedRows == 1) ? true : false;
	}

}
