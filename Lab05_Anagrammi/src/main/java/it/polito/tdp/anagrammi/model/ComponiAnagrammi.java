package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

public class ComponiAnagrammi {
	private Set<String> risultato;

	public Set<String> anagramma(String parola) {
		risultato = new HashSet<String>();
		ricorsiva("", parola);
		return risultato;
	}

	private void ricorsiva(String soluzione, String rimanenti) {
		if (rimanenti.length() == 1) {
			String s = soluzione + rimanenti;
			//System.out.println(s);
			// TODO controlla nel DB se esistono;
			risultato.add(s);
		} else {
			for (int i = 0; i < rimanenti.length(); i++) {
				String temp = rimanenti.substring(0, i) + rimanenti.substring(i + 1);
				ricorsiva(soluzione + rimanenti.charAt(i), temp);
			}
		}
	}

}
