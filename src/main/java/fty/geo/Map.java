/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.geo;

import fty.briefs.books.Books;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franck THERY
 */
public class Map {

    List<City> listCity;

    public Map() {
        listCity = new ArrayList<>();
    }

    public List<City> nearCity(List<Position> group, double radius) {
        List<City> list = new ArrayList<>();
        for (Position pos : group) {
            list.addAll(filterExist(list, nearCity(pos, radius)));
        }
        return list;
    }

    public List<City> nearCity(Position pos, double radius) {
        List<City> list = new ArrayList<>();
        for (City city : listCity) {
            if (pos.distanceOf(city.position) <= radius) {
                list.add(city);
            }
        }
        return list;
    }

    public City nearCity(City city) {
        City nearCity = null;
        double dist = Double.MAX_VALUE;
        for (City cityT : listCity) {
            if (!cityT.equals(city)
                    && city.distanceOf(cityT) < dist) {
                dist = city.distanceOf(cityT);
                nearCity = cityT;
            }
        }
        return nearCity;
    }

    public City getCity(String name) {
        for (City city : listCity) {
            if (city.name.toLowerCase().equals(name.toLowerCase())) {
                return city;
            }
        }
        return null;
    }

    public void loadCsv(String csvFile) {
        File file = new File(csvFile);
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            if (in.ready()) {
                String str;
                while ((str = in.readLine()) != null) {
                    City city = lineToCity(str);
                    if (city != null) {
                        listCity.add(city);
                    }
                }
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<City> filterExist(List<City> ref, List<City> tmp) {
            for (City cRref : ref) {
                if (tmp.contains(cRref)) {
                    tmp.remove(cRref);
                }
            }
        return tmp;
    }

    private City lineToCity(String str) {
        StringTokenizer st = new StringTokenizer(str, ";");
        try {
            String name = st.nextElement().toString();
            double lat = Double.parseDouble(st.nextElement().toString());
            double lon = Double.parseDouble(st.nextElement().toString());
            return new City(name, new Position(lat, lon));
        } catch (Exception ex) {
            return null;
        }
    }
}
