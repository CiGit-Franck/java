/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.bdd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author utilisateur
 */
@Entity
@Table(name = "City")
@NamedQueries(
            {
                @NamedQuery(name = "City.findAll", query = " SELECT c FROM City c ORDER BY c.name "),
                @NamedQuery(name = "City.deleteById", query = " DELETE FROM City c WHERE c.id = :id")
            })
public class City implements Serializable {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    @OneToMany(mappedBy = "city")
    private List<Monument> monuments = new ArrayList<Monument>();

    public City() {
    }

    public City(String name, double latitude, double longitude) {
        this(null, name, latitude, longitude);
    }

    public City(Long id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    @Column(name = "LONGITUDE", nullable = false, scale = 3)
    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Column(name = "LATITUDE", nullable = false, scale = 3)
    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", latitude=" + latitude
                + ", longitude=" + longitude + "]";
    }

}
