
package ptf.model.dao;

/**
 *
 * @author Victor Moraes Ribeiro
 */
public class DAOFactory {
    
    private DAOFactory() {
    }
    
    public static UserLoginDAO getUserLoginDAO() {
        return new UserLoginDAO();
    }
}
