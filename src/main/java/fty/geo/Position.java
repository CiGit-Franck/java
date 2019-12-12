/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.geo;

/**
 *
 * @author Franck THERY
 */
public class Position implements Distance {

    double latitude;
    double longitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Position() {
        this(0.0, 0.0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Position)) {
            throw new IllegalArgumentException();
        }
        Position oA = (Position) o;
        return (this.latitude == oA.latitude
                && this.longitude == oA.longitude);
    }

    @Override
    public int hashCode() {
        return Double.valueOf(this.latitude).hashCode() ^ Double.valueOf(this.longitude).hashCode();
    }

    @Override
    public String toString() {
        return "[" + this.latitude + "; " + this.longitude + "]";
    }

    @Override
    public double distanceOf(Object o) {
        if (o == null || !(o instanceof Position)) {
            throw new IllegalArgumentException();
        }
        Position oA = (Position) o;
        Double lat1 = Double.valueOf(this.latitude);
        Double lat2 = Double.valueOf(oA.latitude);
        Double lon1 = Double.valueOf(this.longitude);
        Double lon2 = Double.valueOf(oA.longitude);
        double dist = round(distanceBetween(lat1, lat2, lon1, lon2).doubleValue(), 2);
        return dist;
    }

    private double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private Double distanceBetween(Double lat1, Double lat2, Double lon1, Double lon2) {
        final int R = 6371; // Radious of the earth
        Double latDistance = toRad(lat2 - lat1);
        Double lonDistance = toRad(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double distance = R * c;
        return distance;
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
