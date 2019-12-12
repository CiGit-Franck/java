package fty.briefs.starwars;

import java.util.List;

/**
 *
 * @author Franck THERY
 */
public interface CRUD<T> {

    public T create(final T entity);

    public List<T> findAll();

    public T findOne(final long id);

    public T update(final T entity);

    public void delete(final T entity);

    public void deleteById(final long entityId);

}
