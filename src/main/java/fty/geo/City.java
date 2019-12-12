/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.geo;

import fty.exos.Person;
import java.util.Objects;

/**
 * @author Franck THERY
 */
public class City implements Distance, Comparable {

    String name;
    Position position;

    public City(String name, Position position) {
        this.name = name;
        this.position = position;
    }
    
    @Override
    public String toString(){
        return this.name + " " + this.position;
    }

    @Override
    public int hashCode() {
//        int hash = 3;
//        hash = 41 * hash + Objects.hashCode(this.name);
//        hash = 41 * hash + Objects.hashCode(this.position);
//        return hash;
        return this.name.hashCode() ^ this.position.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof City)) {
            throw new IllegalArgumentException();
        }
        City oC = (City) o;
        return this.name.equals(oC.name)
                && this.position.equals(oC.position);
    }

    @Override
    public double distanceOf(Object o) {
        if (o == null || !(o instanceof City)) {
            throw new IllegalArgumentException();
        }
        return this.position.distanceOf(((City) o).position);
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((City) o).name);
    }
}
