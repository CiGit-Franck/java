/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.bdd;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author utilisateur
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @ManyToMany
    @JoinTable(name = "USER_MONUMENT",
            joinColumns = {
                @JoinColumn(name = "FK_USER", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "FK_MONUMENT", referencedColumnName = "ID")})
    private Set<Monument> monuments = new HashSet<Monument>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMonument(Monument m) {
        monuments.add(m);
        m.getUsers().add(this);
    }

    public Set<Monument> getMonuments() {
        return monuments;
    }

    public void setMonuments(Set<Monument> monuments) {
        this.monuments = monuments;
    }

    @Override
    public String toString() { 
        return "User :{ id= " + id + "\n name= " + name + "\n nb momunents" + monuments.size() + "\n}";
    }

}
