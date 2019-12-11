 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.briefs.books;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe du programme qui regroupe les fonctionnalitées
 *
 * @author Franck THERY
 */


public class Books {

    private final String DIR_BOOKS = "/fty/briefs/books/data/";
    private final Screens screens = new Screens();
    private final HashMap<String, Book> listBook = new HashMap();
    private final HashMap<String, String> listFile = new HashMap();

    /**
     * Init
     */
    public Books() {
        // Chage la liste des bouquins disponibles 
        if (listFile.isEmpty()) {
            listFiles(getClass().getResource(DIR_BOOKS).getPath());
        }
        // Menu 
        do {
            doAction();
        } while (true);
    }

    /**
     * Ajoute un bouquin en mémoire
     */
    public void addBook() {
        screens.showPossible(listFile);
        Scanner kb = new Scanner(System.in);
        System.out.println("\n\tSaisir le numéro de fichier à ajouter ? : ");
        int index = inputInteger(kb, 1, listFile.size()) - 1;
        Map.Entry<String, String> file = (Entry) listFile.entrySet().toArray()[index];
        if (!listBook.containsKey(file.getKey())) {
            Book book = new Book(file.getKey());
            book.setProperties(mapBook(file.getValue()));
            book.setWords(book.getProperties().size());
            book.setLines(countLineFile(file.getValue()));
            listBook.put(file.getKey(), book);
        } else {
            System.out.println("\n\t\t=> Ce bouquin est déjà dans la liste !");
        }
    }

    /**
     * Supprime un bouquin de la mémoire
     */
    public void deleteBook() {
        screens.showCollection(listBook);
        Scanner kb = new Scanner(System.in);
        System.out.println("\n\tSaisir le numéro du bouquin à supprimer ? : ");
        int index = inputInteger(kb, 1, listBook.size()) - 1;
        Map.Entry<String, Book> book = (Entry) listBook.entrySet().toArray()[index];
        listBook.remove(book.getKey());
    }

    /**
     * Filtre les caractères de signes ou de ponctuations
     *
     * @param line
     * @return line filtrée
     */
    private String lineToWords(String line) {
        String str = "";
        Pattern p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        for (Matcher m1 = p.matcher(line); m1.find();) {
            str += m1.group() + " ";
        }
        return str;
    }

    /**
     * Affiche et gère le menu
     *
     * @return
     */
    private int selected() {
        screens.showPrincipal();
        Scanner kb = new Scanner(System.in);
        return inputInteger(kb, 1, 5);
    }

    /**
     * Actions liés au menu
     */
    private void doAction() {
        switch (selected()) {
            case 1: // Lister les fichiers 
                screens.showPossible(listFile);
                break;
            case 2: // Ajouter un bouquin 
                addBook();
                break;
            case 3: // Supprimer un bouquin 
                if (listBook.isEmpty()) {
                    System.out.println("\n\n\t\t=> Aucun bouquin chargé en mémoire !");
                } else {
                    deleteBook();
                }
                break;
            case 4: // Afficher caractéristique d'un bouquin  
                if (listBook.isEmpty()) {
                    System.out.println("\n\n\t\t=> Aucun bouquin chargé en mémoire !");
                } else {
                    Book book = screens.selectBook(listBook);
                    book.showProperty();
                    compareProperty(book);
                }
                break;
            case 5: // quitter 
                System.out.println("Bye bye !");
                System.exit(0);
                break;
        }
    }

    /**
     * Compare les propriétés de ref avec celles chargés en mémoire
     *
     * @param ref
     */
    private void compareProperty(Book ref) {
        for (Map.Entry<String, Book> obj : listBook.entrySet()) {
            Book book = obj.getValue();
            if (!book.equals(ref)) {
                ref.showDifference(book);
            }
        }
    }

    /**
     * Retourne la liste des fichiers de bouquin disponible
     *
     * @param dir
     */
    private void listFiles(String dir) {
        File root = new File(dir);
        File[] list = root.listFiles();

        for (File f : list) {
            if (f.isDirectory()) {
                listFiles(f.getAbsolutePath());
            } else {
                if (!f.getName().equals("mots.txt")) {
                    listFile.put(f.getName(), f.getAbsolutePath());
                }
            }
        }
    }

    /**
     * Filtre la saisie d'un entier compris entre min et max
     *
     * @param kb
     * @param min
     * @param max
     * @return entier min<=saisie<=mmmax
     */
    protected static int inputInteger(Scanner kb, int min, int max) {
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

    /**
     * Retourne le nombre de ligne du fichier
     *
     * @param fileWithPath
     * @return nombre de ligne
     */
    private int countLineFile(String fileWithPath) {
        int count = 0;
        File file = new File(fileWithPath);
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            if (in.ready()) {
                while (in.readLine() != null) {
                    count++;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    /**
     * Transpose un bouquin en Map<String, int>:<mot, occurrence>
     *
     * @param fileName
     * @return bouquin mappé
     */
    private HashMap<String, Integer> mapBook(String fileName) {
        File file = new File(fileName);
        BufferedReader in;
        HashMap<String, Integer> words = new HashMap<>();
        try {
            in = new BufferedReader(new FileReader(file));
            if (in.ready()) {
                loadBook(words, in);
            }
        } catch (IOException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        return words;
    }

    /**
     * Decompose le bouquin chargé en mémoire Map<String, int>:<mot, occurrence>
     *
     * @param words
     * @param in
     * @throws IOException
     */
    private void loadBook(HashMap<String, Integer> words, BufferedReader in) throws IOException {
        String str;
        while ((str = in.readLine()) != null) {
//            String formated = lineToWords(str);
            StringTokenizer st = new StringTokenizer(lineToWords(str));
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                int val = 1;
                if (words.containsKey(key)) {
                    val = (words.get(key)) + 1;
                }
                words.put(key, val);
            }
        }
    }

    /**
     * Execute la classe : fty.briefs.book.Books
     *
     * @param args
     */
    public static void main(String[] args) {
        new Books();
    }

}
