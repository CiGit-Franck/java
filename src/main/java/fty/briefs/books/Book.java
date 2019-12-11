/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.briefs.books;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe définissant un bouquin
 *
 * @author Franck THERY
 */
public class Book {

    private String name;
    private int lines;
    private int words;
    private HashMap<String, Integer> properties;

    /**
     * Constructeur
     *
     * @param name
     */
    public Book(String name) {
        this.name = name;
        this.lines = 0;
        this.words = 0;
        this.properties = new HashMap();
    }

    /**
     * Affiche les caracteristiques du bouquin
     */
    public void showProperty() {
        System.out.println("Propriétés de " + getName());
        System.out.println("\t- Il contient " + getLines() + " lignes");
        System.out.println("\t- Il contient " + getWords() + " mots");
        System.out.println("\t- Liste des 50 mots les plus cités dans ce bouquin :");
        Map<String, Integer> copy = (HashMap<String, Integer>) getProperties().entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (int i = 1; i <= 50; i++) {
            Map.Entry<String, Integer> entry = copy.entrySet().stream().max((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).get();
            System.out.println("\t" + i + " - " + entry.getKey() + " est présent avec " + entry.getValue().toString() + " occurrences ");
            copy.remove(entry.getKey());
        }
    }

    /**
     * Affiche la différence de caractéristiques avec other
     *
     * @todo Afficher pour chacun des autres fichiers le pourcentage de mots de
     * l'autre fichier qui sont présents dans le fichier sélectionnés, par ordre
     * décroissant de ce pourcentage.
     * 
     * @param other
     */
    public void showDifference(Book other) {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La comparaison entre " + getName() + " et " + other.getName());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t- Liste des mots présents seulement dans " + getName() + " :");
        Map<String, Integer> copy = (HashMap<String, Integer>) getProperties().entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<String, Integer> otherCopy = (HashMap<String, Integer>) other.getProperties().entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        HashSet<String> unionKeys = new HashSet<>(copy.keySet());   // add full keys ref
        unionKeys.addAll(otherCopy.keySet());                       // add full keys other
        unionKeys.removeAll(otherCopy.keySet());                    // del keys other 

        // unionKeys ne contient que les mots uniques du bouquin sélectionné 
        for (String mot : unionKeys) {
            System.out.println("\t" + mot + " est présent uniquement dans " + getName());
        }
        // Intersection des clés
        HashSet<String> bookKeys = new HashSet<>(copy.keySet());
        HashSet<String> otherKeys = new HashSet<>(otherCopy.keySet());
        bookKeys.retainAll(otherKeys);
        String percent = String.format( "%.2f", (double)(1.0*(bookKeys.size()*100/otherKeys.size())) )+" %";
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(other.getName()+" contient "+percent+" de mots identiques");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public HashMap<String, Integer> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Integer> properties) {
        this.properties = properties;
    }
}
