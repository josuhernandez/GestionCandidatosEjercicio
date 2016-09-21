package com.ipartek.formacion.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@NotNull
	@Size(9)
	private String telefono1;

}
