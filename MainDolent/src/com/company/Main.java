package com.company;

import java.util.Scanner;
import java.util.Random;

/**
 * El main és la clase principal que conté el codi executable
 * 
 * @author Emilio Casas
 *
 */
public class Main {

	/**
	 * És el primer codi s'executa per defecte en un programa. Executa la funció
	 * nova lletra mentre que els errors son menors que 5 i no se ha encertat la
	 * paraula.
	 * 
	 * @param args
	 *            serveix per poder presentar i llegir dades.
	 */

	public static void main(String[] args) {
		Paraula paraula = new Paraula();

		System.out.println("Comença el joc!");

		System.out.println(paraula.getP());

		Scanner reader = new Scanner(System.in);

		int num_errors = 0;

		while (!paraula.getP().equals(paraula.getParaula()) && num_errors < 5) {
			if (!paraula.buscar_lletra(reader.next().charAt(0))) {
				num_errors++;
			}
			System.out.println(paraula.getP());
		}
		reader.close();
	}
}

class Paraula {
	String paraules[] = { "hola", "programació", "casa" };
	String p = "";
	int index;

	public Paraula() {
		Random rand = new Random();
		index = rand.nextInt(3);
		for (int i = 0; i < paraules[index].length(); i++) {
			p += "_";
		}
	}

	public String getParaula() {
		return paraules[index];
	}

	public String getP() {
		return p;
	}

	public int getIndex() {
		return index;
	}

	/**
	 * És una funció que serveix per buscar una lletra i descubrir-la.
	 * 
	 * @param nova
	 *            es la lletra a buscar.
	 * @return retorna verdader o fals (si se ha trobat o no).
	 */
	public boolean buscar_lletra(char nova) {
		boolean trobada = false;
		String paraula_old = p;
		p = "";
		for (int i = 0; i < paraules[index].length(); i++) {
			if (paraules[index].charAt(i) == nova) {
				p += paraules[index].charAt(i);
				trobada = true;
			} else {
				p += paraula_old.charAt(i);
			}
		}
		return trobada;
	}

}
