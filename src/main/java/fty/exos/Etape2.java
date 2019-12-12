/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

import java.util.GregorianCalendar;

/**
 *
 * @author utilisateur
 */
public class Etape2 {

    double prixHT;
    double tauxTVA;
    double prixTTC;
    static GregorianCalendar cal = new GregorianCalendar();

    public Etape2(double prixHT, double tauxTVA) {
        this.prixHT = prixHT;
        this.tauxTVA = tauxTVA;
        System.out.println(prixHT + " (HT)\t" + tauxTVA + " (%) => " + getPrixTCC());
    }
    
    public static boolean isBissextile(int year) {
        return cal.isLeapYear(year);
    }

    public double getPrixTCC() {
        return prixHT * (1 + tauxTVA / 100);
    }

    public static void main(String[] args) {
        // write your code here
        new Etape2(100, 20);
    }

}
