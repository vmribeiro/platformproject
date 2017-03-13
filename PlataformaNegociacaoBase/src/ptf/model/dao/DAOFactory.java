
package ptf.model.dao;

/**
 *
 * @author Victor Moraes Ribeiro
 */
public class DAOFactory {
    
    private DAOFactory() {
    }
    
    public static UserDAO getUserLoginDAO() {
        return new UserDAO();
    }
}
