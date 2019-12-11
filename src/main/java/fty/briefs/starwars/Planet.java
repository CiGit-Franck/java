package fty.briefs.starwars;

import java.util.Objects;

/**
 *
 * @author Franck THERY
 */
public class Planet {
    
    private Long id;
    private String planetName;
    private int rotationPeriod;
    private int orbitalPeriod;
    private int diameter;
    private double gravity;
    private int surfaceWater;
    private int population;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.planetName);
        hash = 17 * hash + this.rotationPeriod;
        hash = 17 * hash + this.orbitalPeriod;
        hash = 17 * hash + this.diameter;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.gravity) ^ (Double.doubleToLongBits(this.gravity) >>> 32));
        hash = 17 * hash + this.surfaceWater;
        hash = 17 * hash + this.population;
        return hash;
    }

    @Override
    public String toString() {
        return "Planet{" + "planet_name=" + planetName + ", rotation_period=" + rotationPeriod + ", orbital_period=" + orbitalPeriod + ", diameter=" + diameter + ", gravity=" + gravity + ", surface_water=" + surfaceWater + ", population=" + population + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planet other = (Planet) obj;
        if (this.rotationPeriod != other.rotationPeriod) {
            return false;
        }
        if (this.orbitalPeriod != other.orbitalPeriod) {
            return false;
        }
        if (this.diameter != other.diameter) {
            return false;
        }
        if (Double.doubleToLongBits(this.gravity) != Double.doubleToLongBits(other.gravity)) {
            return false;
        }
        if (this.surfaceWater != other.surfaceWater) {
            return false;
        }
        if (this.population != other.population) {
            return false;
        }
        if (!Objects.equals(this.planetName, other.planetName)) {
            return false;
        }
        return true;
    }
    
}
