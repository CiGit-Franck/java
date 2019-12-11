/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.bdd;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author utilisateur
 */
public abstract class DAO<T> implements IDao<T> {

    protected EntityManager em;
    private Class<T> clazz;

    public DAO(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    @Override
    public T findOne(long id) {
        return em.find(clazz, id);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public T create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(long entityId) {
        delete(findOne(entityId));
    }
}
