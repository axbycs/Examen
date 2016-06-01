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

    static protected String paraules[] = {"hola","programació","casa"};
    static protected int index;
    static protected String p = "";
    
    /**
     * És el primer codi s'executa per defecte en un programa.
     * Executa la funció novalletra mentre que els errors son menors que 5
     * i no se ha encertat la paraula.
     * 
     * @param args serveix per poder presentar i llegir dades.
     */

    public static void main(String[] args) {
        System.out.println("Comença el joc!");

        Random rand = new Random();
        index = rand.nextInt(3);
        for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }

        System.out.println(p);

        Scanner reader = new Scanner(System.in);

        int num_errors = 0;

        while (!p.equals(paraules[index]) && num_errors < 5) {
            if (!nova_lletra(reader.next().charAt(0))) {
                num_errors++;
            }
            System.out.println(p);
        }
   }
    
    /**
     * És una funció que serveix per buscar una lletra i descubrir-la.
     * 
     * @param nova es la lletra a buscar.
     * @return retorna verdader o fals (si se ha trobat o no).
     */

    static public boolean nova_lletra(char nova) {
        boolean trobada = false;
        String paraula_old = p;
        p = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                p += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                p += paraula_old.charAt(i);
            }
        }
        return trobada;
    }

}

