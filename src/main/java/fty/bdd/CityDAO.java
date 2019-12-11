/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.bdd;

import javax.persistence.EntityManager;

/**
 *
 * @author utilisateur
 */
public class CityDAO  extends DAO<City> {

    public CityDAO(EntityManager em) {
        super(em, City.class);
    }
}
