
package ptf.model.dao;

import ptf.model.entities.UserLogin;

/**
 *
 * @author Victor Moraes Ribeiro
 */
public interface IUserDAO extends GenericDAO<UserLogin>{
    public UserLogin findByEmail(String email);
}
