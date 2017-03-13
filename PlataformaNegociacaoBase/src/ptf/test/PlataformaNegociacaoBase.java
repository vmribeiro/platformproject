package ptf.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import ptf.model.dao.DAOFactory;
import ptf.model.dao.IUserDAO;
import ptf.model.entities.UserLogin;
import ptf.model.entities.UserProfile;

/**
 *
 * @author Victor Moraes Ribeiro
 */
public class PlataformaNegociacaoBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        UserLogin ul = new UserLogin();
//        ul.setEmail("vm.ribeiro@outlook.com");
//        ul.setSenha("titogzej4");
//        ul.setType(1);
//        
        UserProfile up = new UserProfile();
//        up.setAdvertiserMark(0.0);
//        up.setAvatar(null);
//        up.setCep("06764-045");
//        up.setCity("Taboão da Serra");
//        up.setCountryState("SP");
//        up.setCpf("474.773.838-03");
//        try {
//            up.setDtaNasc(df.parse("21/11/1997"));
//        } catch (ParseException ex) {
//            Logger.getLogger(PlataformaNegociacaoBase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        up.setLastnameUser("Ribeiro");
//        up.setNameUser("Victor");
//        up.setNegociationsNumber(0);
//        up.setPhone("(11)97641-3510");
//        up.setRg("38.264.001-9");
//       
//        ul.setUserProfile(up);

        IUserDAO uld = DAOFactory.getUserLoginDAO();
//        ul = (UserLogin) uld.findById(3);
//        System.out.println(ul);
//        ul.setEmail("jonas@alter.com");
//        ul.setSenha("alterjonas");
//        System.out.println(uld.save(ul));
//        System.out.println(uld.remove(3));
        System.out.println(uld.findById(0));
//        List<UserLogin> all = (ArrayList<UserLogin>)uld.findAll();
//        all.forEach((userLogin) -> {
//            System.out.println(userLogin);
//        });
    }

}
