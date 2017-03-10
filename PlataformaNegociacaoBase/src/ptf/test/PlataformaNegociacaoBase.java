
package ptf.test;

import java.util.ArrayList;
import java.util.List;
import ptf.model.dao.DAOFactory;
import ptf.model.dao.GenericDAO;
import ptf.model.entities.UserLogin;

/**
 *
 * @author Victor Moraes Ribeiro
 */
public class PlataformaNegociacaoBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserLogin ul = new UserLogin();
//        ul.setEmail("maria@maria.com");
//        ul.setSenha("124142");
//        ul.setTipo(1);
        GenericDAO uld = DAOFactory.getUserLoginDAO();
//        ul = (UserLogin) uld.findById(3);
//        System.out.println(ul);
//        ul.setEmail("jonas@alter.com");
//        ul.setSenha("alterjonas");
//        System.out.println(uld.save(ul));
//        System.out.println(uld.remove(3));
        List<UserLogin> all = (ArrayList<UserLogin>)uld.findAll();
        all.forEach((userLogin) -> {
            System.out.println(userLogin);
        });
    }
    
}
