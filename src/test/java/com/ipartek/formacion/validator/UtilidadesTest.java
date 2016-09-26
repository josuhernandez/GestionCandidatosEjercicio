package com.ipartek.formacion.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ipartek.formacion.validation.Utilidades;

public class UtilidadesTest {

	@Test
	public void testIsValidDni() {

		assertTrue(Utilidades.isValidDni("11111111H"));
		assertTrue(Utilidades.isValidDni("11111111h"));

		assertFalse("NO se controla la letra", Utilidades.isValidDni("11111111"));
		assertFalse(Utilidades.isValidDni(null));
		assertFalse(Utilidades.isValidDni("11111111-H"));
		assertFalse(Utilidades.isValidDni("11111111 H"));
		assertFalse(Utilidades.isValidDni("111H"));
		assertFalse(Utilidades.isValidDni("11111111"));
	}

}
