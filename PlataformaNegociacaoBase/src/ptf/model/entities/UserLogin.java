package ptf.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Victor Moraes Ribeiro
 */
@Entity
@Table(name = "usuario_login")
public class UserLogin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_login")
    private long idLogin;
    
    @Column(name = "email_usuario")
    private String email;
    
    @Column(name = "senha_usuario")
    private String senha;
    
    @Column(name = "tipo_usuario")
    private int tipo;

    public UserLogin() {
    }

    public long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(long idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "UserLogin{" + "idLogin=" + idLogin + ", email=" + email + ", senha=" + senha + ", tipo=" + tipo + '}';
    }
}
