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
public class MonumentDAO extends DAO<Monument> {
    
    public MonumentDAO(EntityManager em) {
        super(em, Monument.class);
    }
}
