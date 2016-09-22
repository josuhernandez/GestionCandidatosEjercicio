package com.ipartek.formacion.domain;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private long id;

	@NotNull
	@Size(min = 8, max = 9)
	private String dni;

	@NotNull
	@Size(min = 3, max = 199)
	private String nombre;

	@NotNull
	@Size(min = 3, max = 199)
	private String apellido1;

	@NotNull
	@Size(min = 3, max = 199)
	private String apellido2;

	@NotNull
	@Size(min = 3, max = 199)
	private String email;

	@Min(0)
	@Max(9)
	private String telefono1;

	@Min(0)
	@Max(9)
	private String telefono2;

	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String fecha_nacimiento;

	// getter y setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// toString
	@Override
	public String toString() {
		return "Candidato [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
	}

}
