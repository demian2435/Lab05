package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {
		ComponiAnagrammi ca = new ComponiAnagrammi();
		
		for(String x: ca.anagramma("tea")) {
			System.out.println(x);
		}
	}

}
