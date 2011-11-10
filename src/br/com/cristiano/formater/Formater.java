package br.com.cristiano.formater;

import java.text.NumberFormat;
import java.text.ParseException;

public class Formater {

	private static final NumberFormat nf = NumberFormat.getCurrencyInstance();

	public static Double formatToDouble(String s) throws ParseException {
			return (nf.parse(s)).doubleValue();
	}

}
