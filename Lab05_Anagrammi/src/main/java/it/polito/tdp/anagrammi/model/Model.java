package it.polito.tdp.anagrammi.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Model {

	private DizionarioDAO dao = new DizionarioDAO();
	private ComponiAnagrammi ca = new ComponiAnagrammi();

	public Set<String> anagrammi(String parola) {
		return ca.anagramma(parola);
	}

	public Map<String, Boolean> anagrammiReali(String parola) {
		Map<String, Boolean> result = new HashMap<String, Boolean>();

		for (String s : ca.anagramma(parola)) {
			result.put(s, dao.esisteParola(s));
		}

		return result;
	}
	
	public Map<String, Boolean> anagrammiRealiDB(String parola){
		return dao.esisteParole(anagrammi(parola));
	}

}
