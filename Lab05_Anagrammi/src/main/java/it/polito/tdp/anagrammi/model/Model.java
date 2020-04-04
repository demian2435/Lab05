package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class Model {

	ComponiAnagrammi ca = new ComponiAnagrammi();

	public Set<String> anagrammi(String parola) {
		return ca.anagramma(parola);
	}

}
