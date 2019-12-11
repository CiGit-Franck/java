/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author utilisateur
 */
public final class Etape4 {

    public Etape4() {
        do {
            myPrograms();
        } while (true);
    }

    public void myPrograms() {
        Scanner kb;
        switch (choiceFunction()) {
            case 1: // bissextile 
                kb = new Scanner(System.in);
                System.out.println("\n\nEntrez une année ? : ");
                int year = inputAnnee(kb);
                System.out.println(year + " est-il un bissextile : " + ((Etape2.isBissextile(year)) ? "oui" : "non"));
                break;
            case 2: // palindrome
                kb = new Scanner(System.in);
                System.out.println("\n\nEntrez un mot ? : ");
                String mot = kb.nextLine();
                System.out.println(mot + " est-il un palindrome : " + ((Etape3.isPalindrome(mot)) ? "oui" : "non"));
                break;
            case 3: // nbr premiers
                kb = new Scanner(System.in);
                System.out.println("\n\nEntrez un nombre min ? : ");
                int min = inputEntier(kb, 0, Integer.MAX_VALUE);
                System.out.println("\n\nEntrez un nombre max ? : ");
                int max = inputEntier(kb, min, Integer.MAX_VALUE);
                Etape3.showNombresPremier(min, max);
                break;
            case 4: // table multiple 
                kb = new Scanner(System.in);
                System.out.println("\n\nEntrez le nombre de ligne ? : ");
                int row = inputEntier(kb, 0, Integer.MAX_VALUE);
                System.out.println("\n\nEntrez le nombre de colonne ? : ");
                int col = inputEntier(kb, 0, Integer.MAX_VALUE);
                Etape3.tableMultiple(row, col);
                break;
            case 5: // quitter 
                System.out.println("Bye {@}");
                System.exit(0);
                break;
        }
    }

    private static void menu() {
        System.out.println("\n\nVeuillez saisir ");
        System.out.println("\t1 - pour valider une année bissextile ?");
        System.out.println("\t2 - pour valider un palindrome ?");
        System.out.println("\t3 - pour afficher les nombres premiers ?");
        System.out.println("\t4 - pour afficher la table des multiples ?");
        System.out.println("\t5 - pour quitter le programme !");
        System.out.println();
        System.out.println("votre choix : ");
    }
    
    private int inputAnnee(Scanner kb){
        return inputEntier(kb, 0, 9999);
    }

    private int inputEntier(Scanner kb, int min, int max) {
        boolean valid = false;
        int in = -1;
        do {
            try {
                in = kb.nextInt();
                if (in >= min && in <= max) {
                    valid = true;
                } else {
                    System.out.println("Veuillez saisir un entier entre " + min + " et " + max);
                }
            } catch (InputMismatchException ie) {
                System.out.println("Veuillez saisir un entier entre " + min + " et " + max);
                if (kb.hasNext()) {
                    kb.next();
                }
            }
        } while (!valid);
        return in;
    }

    public int choiceFunction() {
        Scanner kb = new Scanner(System.in);
        menu();
        return inputEntier(kb, 1, 5);
    }

    public static void main(String[] args) {
        new Etape4();
    }
}
