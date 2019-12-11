/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.briefs.books;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe qui gère l'affichage
 *
 * @author Franck THERY
 */
public final class Screens {

    /**
     * Efface la console
     *
     * @todo à mettre au point
     */
    public void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final IOException e) {
            //  Handle any exceptions.
        } catch (InterruptedException ex) {
            Logger.getLogger(Screens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Affiche la liste des bouquins disponibles
     *
     * @param list
     */
    public void showPossible(HashMap<String, String> list) {
        int count = 1;
        System.out.println("\n\tListe des bouquins disponibles :");
        for (Map.Entry book : list.entrySet()) {
            System.out.println("\t\t" + (count++) + " - " + book.getKey());
        }
    }

    /**
     * Affiche la liste des bouquins chargés
     *
     * @param list
     */
    public void showCollection(HashMap<String, Book> list) {
        int count = 1;
        System.out.println("\n\tListe des bouquins chargés en mémoire :");
        for (Map.Entry book : list.entrySet()) {
            System.out.println("\t\t" + (count++) + " - " + book.getKey());
        }
    }

    /**
     * Affiche le sous menu Fichier
     *
     * @param list
     * @return
     */
    public Book selectBook(HashMap<String, Book> list) {
        showCollection(list);
        System.out.println("\n\tSaisir le numéro du bouquin à sélectionner ? : ");
        int index = Books.inputInteger(new Scanner(System.in), 1, list.size()) - 1;
        Map.Entry<String, Book> book = (Map.Entry) list.entrySet().toArray()[index];
        return book.getValue();
    }

    /**
     * Affiche le menu principal
     */
    public void showPrincipal() {
        System.out.println("\n\nMENU :\n");
        System.out.println("\t1 - Lister les fichiers disponibles ?");
        System.out.println("\t2 - Ajouter un fichier en mémoire ?");
        System.out.println("\t3 - Supprimer un fichier en mémoire ?");
        System.out.println("\t4 - Afficher des informations sur un livre ?");
        System.out.println("\t5 - Quitter le programme !");
        System.out.println();
        System.out.println("votre choix : ");
    }

}
