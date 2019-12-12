/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.io;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author utilisateur
 */
public class Scan {

    /**
     * Filters entering a double between min and max
     *
     * @param kb
     * @param min
     * @param max
     * @return double min<=saisie<=mmmax
     */
    private static double inputDouble(Scanner kb, double min, double max, String ask) {
        boolean valid = false;
        double in = -1.0;
        String msgError = "Veuillez saisir un double entre " + min + " et " + max;
        do {
            try {
                in = kb.nextDouble();
                if (in >= min && in <= max) {
                    valid = true;
                } else {
                    System.out.println(msgError);
                    System.out.println(ask);
                }
            } catch (InputMismatchException ie) {
                System.out.println(msgError);
                System.out.println(ask);
                if (kb.hasNext()) {
                    kb.next();
                }
            }
        } while (!valid);
        return in;
    }

    /**
     * Filters the entry of an integer between min and max
     *
     * @param kb
     * @param min
     * @param max
     * @return entier min<=saisie<=mmmax
     */
    public static int inputInteger(Scanner kb, int min, int max, String ask) {
        boolean valid = false;
        int in = -1;
        String msgError = "Veuillez saisir un entier entre " + min + " et " + max;
        do {
            try {
                in = kb.nextInt();
                if (in >= min && in <= max) {
                    valid = true;
                } else {
                    System.out.println(msgError);
                    System.out.println(ask);
                }
            } catch (InputMismatchException ie) {
                System.out.println(msgError);
                System.out.println(ask);
                if (kb.hasNext()) {
                    kb.next();
                }
            }
        } while (!valid);
        return in;
    }
    
}
