package fty.briefs.fitness;

import java.util.Objects;

/**
 * Set a setting
 *
 * @author Franck THERY
 */
public class Set {

    private String name;
    private int nbIter;
    private double weight;

    /**
     * Create a Setting
     *
     * @param name
     */
    public Set(String name) {
        this(name, 0, 0.0);
    }

    /**
     * Create a Setting
     *
     * @param name
     * @param nbIter
     * @param weight
     */
    public Set(String name, int nbIter, double weight) {
        this.name = name;
        this.nbIter = nbIter;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.name + ";" + this.nbIter + ";" + this.weight + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Set)) {
            return false;
        }
        Set oS = (Set) o;
        return this.name.equals(oS.name)
                && this.nbIter == oS.nbIter
                && this.weight == oS.weight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + this.nbIter;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbIter() {
        return nbIter;
    }

    public void setNbIter(int nbIter) {
        this.nbIter = nbIter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
