/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class Seminar {

    private Person coach;
    private ArrayList<Person> group;

    /**
     * Copie superficielle
     * @param coach
     * @param group 
     */
    public Seminar(Person coach, ArrayList<Person> group) {
        this.coach = coach;
        this.group = group;
    }
}
