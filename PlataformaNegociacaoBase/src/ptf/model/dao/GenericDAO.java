
package ptf.model.dao;

import java.util.List;

/**
 *
 * @author Victor Moraes Ribeiro
 * @param <E>
 */
public interface GenericDAO<E> {
    public boolean save(E e);
    public boolean update(E e);
    public boolean remove(long id);
    public E findById(long id);
    public List<E> findAll();
}
