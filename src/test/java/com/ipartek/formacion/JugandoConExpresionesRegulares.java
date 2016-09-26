package com.ipartek.formacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JugandoConExpresionesRegulares {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReemplazar() {

		// a*b es una máscara que permite una cadena que empiece por a,
		// acabe en b y entremedias puede tener cualquier caracter
		Pattern patron = Pattern.compile("a*b");
		Pattern patron2 = Pattern.compile("abc");
		// patron de validación para un dni
		// los 8 primeros digitos tienen que ser números
		// y el 9º una letra May o Min
		Pattern mask = Pattern.compile("[0-9]{8}[a-zA-Z]");

		Matcher matcher = patron.matcher("ab");
		assertTrue(matcher.find());

		matcher = patron.matcher("aaabbb");
		assertTrue(matcher.find());

		matcher = patron.matcher("ac");
		assertFalse(matcher.find());

		matcher = patron2.matcher("abc");
		assertTrue(matcher.matches());

		matcher = patron2.matcher("abs");
		assertFalse(matcher.matches());

		// pruebas de validación de un dni
		matcher = mask.matcher("12345678a");
		assertTrue(matcher.matches());

		matcher = mask.matcher("1234a678a");
		assertFalse(matcher.matches());
	}

}
