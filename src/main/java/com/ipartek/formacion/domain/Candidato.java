package com.ipartek.formacion.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ipartek.formacion.validation.Nif;

public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private long id;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String nombre;

	@Nif
	private String dni;

	private Timestamp fechaAlta;

	public Candidato() {
		super();
		this.id = 0;
		this.nombre = "";
		this.dni = "";

	}

	/* GETTERS AND SETTERS */

	/**
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return this.dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the fechaAlta
	 */
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta
	 *            the fechaAlta to set
	 */
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isNew() {
		return (this.id == 0) ? true : false;
	}

	/* TO STRING */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", fechaAlta=" + fechaAlta + "]";
	}

}
