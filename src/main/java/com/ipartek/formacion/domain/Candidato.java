package com.ipartek.formacion.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ipartek.formacion.validation.Nif;

public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private long id;

	@NotNull
	@Size(max = 50)
	private String nombre;

	@Nif
	private String dni;

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
		return "Candidato [id=" + this.id + ", nombre=" + this.nombre + ", dni=" + this.dni + "]";
	}

}
