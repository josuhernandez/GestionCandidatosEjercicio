package com.ipartek.formacion.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

	public static boolean isValidDni(String dni) {

		boolean resul = false;
		Pattern mask = Pattern.compile("[0-9]{8}[A-Za-z]");
		final String LETRAS_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";

		if (dni != null) {
			// controlamos que se cumple el patron de DNI
			// 8 numeros y una letra (mayus o minus)

			Matcher matcher = mask.matcher(dni);
			if (matcher.matches()) {
				// comprobamos la letra de control
				int numero = Integer.valueOf(dni.substring(0, 8));
				String letra = dni.substring(8, 9).toUpperCase();
				// lo convertimos a mayusculas

				int resto = numero % 23;
				// nos devuelve resto de dividir entre 23

				char letraControl = LETRAS_CONTROL.charAt(resto);
				// devuelve la letra de LETRAS_CONTROL de la posicion en que
				// indica 'resto'

				if (letra.equals(String.valueOf(letraControl))) {
					resul = true;
				}
			}

		}

		return resul;
	}

}
