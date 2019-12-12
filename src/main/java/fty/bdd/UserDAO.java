package fty.bdd;

import javax.persistence.EntityManager;

/**
 *
 * @author utilisateur
 */
public class UserDAO extends DAO<User> {

    public UserDAO(EntityManager em) {
        super(em, User.class);
    }
    
}
