/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.geo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franck THERY
 */
public class Main {

    static Map map = new Map();

    public static void main(String[] args) {
//        map.loadCsv(args[0]);
        map.loadCsv("C:\\devpt\\repository\\corp-bnp-renault\\session1\\ressource\\Communes.csv");
// calculer la distance d'une commune à un point quelconque repéré par ses latitude et longitude.
        City city1 = map.getCity("Toulouse");
        Position pos = new Position(45.0, 2.0);
        System.out.println("La distance de " + city1.name + " au point " + pos + " est de " + city1.position.distanceOf(pos));
// calculer la distance d'une commune à une autre commune.
        City city2 = map.getCity("Montreuil");
        System.out.println("La distance de " + city1 + " à " + city2 + " est de " + city2.position.distanceOf(pos));
// trouver la commune la plus proche d'une commune
        System.out.println("La ville la plus proche de " + city1 + " est " + map.nearCity(city1).name);
// trouver les communes qui sont présentes dans un rayon donné autour d'un point quelconque
        List<City> list = map.nearCity(pos, 5.0);
        System.out.println("Les villes qui se trouvent dans un rayon de 5km de la position " + pos);
        for (City city : list) {
            System.out.println(city);
        }
// trouver les communes qui sont simultanément dans un rayon donnée d'un ensemble de points quelconques
        List<Position> listPos = new ArrayList<>();
        listPos.add(new Position(45.033333, 1.966667));
        listPos.add(new Position(45.016667, 1.95));
        list = map.nearCity(listPos, 5.0);
        System.out.println("Les villes qui se trouvent dans un rayon de 5km des positions " + listPos);
        for (City city : list) {
            System.out.println(city);
        }
    }
}
