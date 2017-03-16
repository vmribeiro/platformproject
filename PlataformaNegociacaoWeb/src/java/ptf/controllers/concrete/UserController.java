package ptf.controllers.concrete;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import ptf.controller.AbstractController;
import ptf.model.dao.DAOFactory;
import ptf.model.dao.IUserDAO;
import ptf.model.entities.UserLogin;
import ptf.model.entities.UserProfile;

/**
 *
 * Classe que faz as operações necessárias para os clientes
 *
 * @author Victor Moraes Ribeiro
 *
 */
public class UserController extends AbstractController {

    private final IUserDAO udao = DAOFactory.getUserLoginDAO();

    @Override
    public void execute() {
        String action = this.getRequest().getParameter("action");
        switch (action) {
            case "login":
                login();
                break;
            case "logoff":
                logoff();
                break;
            case "register":
                register();
                break;
            case "forwardToUpdatePage":
                forwardToUpdatePage();
                break;
            case "update":
                update();
                break;
        }
    }

    private void login() {
        String email = this.getRequest().getParameter("email");
        String password = this.getRequest().getParameter("password");
        //Search in db
        UserLogin ul = udao.findByEmail(email);
        authenticate(ul, email, password);
    }

    private void logoff() {
        this.getRequest().getSession().invalidate();
        setSession("answer", "<script> alert('Logoff efetuado'); </script>");
        this.setReturnPage("index.jsp");
    }

    private void register() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        //Take the parameters and initialize the objects
        UserProfile up = new UserProfile();
        up.setAdvertiserMark(0.0);
        up.setAvatar(null);
        up.setCep(this.getRequest().getParameter("cep"));
        up.setCity(this.getRequest().getParameter("city"));
        up.setCountryState(this.getRequest().getParameter("countryState"));
        up.setCpf(this.getRequest().getParameter("cpf"));
        try {
            up.setDtaNasc(df.parse(this.getRequest().getParameter("dtaNasc")));
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        up.setLastnameUser(this.getRequest().getParameter("lastname"));
        up.setNameUser(this.getRequest().getParameter("name"));
        up.setNegociationsNumber(0);
        up.setPhone(this.getRequest().getParameter("phone"));
        up.setRg(this.getRequest().getParameter("rg"));
        UserLogin ul = new UserLogin();
        ul.setEmail(this.getRequest().getParameter("email"));
        ul.setSenha(this.getRequest().getParameter("password"));
        ul.setType(1);
        ul.setUserProfile(up);

        if (udao.save(ul)) {
            this.setReturnPage("index.jsp");
            setSession("answer", "Cadastro efetuado!");
        } else {
            setSession("answer", "Erro ao fazer o registro! Tente novamente");
            this.setReturnPage("cadastro.jsp");
        }

    }

    private void update() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        UserLogin ul = udao.findById(Long.parseLong(this.getRequest().getParameter("id")));
        ul.setEmail(this.getRequest().getParameter("email"));
        ul.setSenha(this.getRequest().getParameter("password"));
        ul.setType(1);
        //Take the parameters and initialize the objects
        ul.getUserProfile().setAdvertiserMark(0.0);
        ul.getUserProfile().setCep(this.getRequest().getParameter("cep"));
        ul.getUserProfile().setCity(this.getRequest().getParameter("city"));
        ul.getUserProfile().setCountryState(this.getRequest().getParameter("countryState"));
        ul.getUserProfile().setCpf(this.getRequest().getParameter("cpf"));
        try {
            ul.getUserProfile().setDtaNasc(df.parse(this.getRequest().getParameter("dtaNasc")));
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ul.getUserProfile().setLastnameUser(this.getRequest().getParameter("lastname"));
        ul.getUserProfile().setNameUser(this.getRequest().getParameter("name"));
        ul.getUserProfile().setNegociationsNumber(0);
        ul.getUserProfile().setPhone(this.getRequest().getParameter("phone"));
        ul.getUserProfile().setRg(this.getRequest().getParameter("rg"));

        if (udao.update(ul)) {
            this.setReturnPage("home.jsp");
        } else {
            setSession("answer", "Erro ao fazer a atualização! Tente novamente");
            this.setReturnPage("atualizarPerfil.jsp");
        }
    }

    private void authenticate(UserLogin ul, String email, String password) {
        if (ul == null) {
            setSession("answer", "Email incorreto!");
            this.setReturnPage("index.jsp");
        } else if (!ul.getSenha().equals(password)) {
            setSession("answer", "Senha incorreta!");
            this.setReturnPage("index.jsp");
        } else {
            setSession("user", ul);
            setSession("link", "<a href='FrontControllerServlet?control=User&action=logoff'>Logoff</a>");
            this.setReturnPage("home.jsp");
        }
    }

    private void setSession(String sessionName, String value) {
        this.getRequest().getSession().setAttribute(sessionName, value);
    }

    private void setSession(String sessionName, UserLogin value) {
        this.getRequest().getSession().setAttribute(sessionName, value);
    }

    private void forwardToUpdatePage() {
        UserLogin ul = udao.findById(Long.parseLong(this.getRequest().getParameter("id")));
        if (ul != null) {
            setSession("user", ul);
        } else {
            setSession("answer", "Erro ao atualizar o perfil! Tente novamente.");
        }
        this.setReturnPage("atualizarPerfil.jsp");
    }
}
