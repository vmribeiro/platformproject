package ptf.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Victor Moraes Ribeiro
 */
@Entity
@Table(name = "usuario_perfil")
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idPerfil;

    @Column(name = "nome_usuario")
    private String nameUser;

    @Column(name = "sobrenome_usuario")
    private String lastnameUser;

    @Column(name = "cpf_usuario")
    private String cpf;

    @Column(name = "rg_usuario")
    private String rg;

    @Column(name = "estado_usuario")
    private String countryState;

    @Column(name = "cidade_usuario")
    private String city;

    @Column(name = "cep_usuario")
    private String cep;

    @Column(name = "cel_usuario")
    private String phone;

    @Temporal(TemporalType.DATE)
    @Column(name = "nasc_usuario")
    private Date dtaNasc;

    @Lob
    @Column(name = "avatar_usuario")
    @Basic(fetch = FetchType.LAZY)
    private byte[] avatar;

    @Column(name = "nota_anunciante")
    private Double advertiserMark;

    @Column(name = "qtd_negociacoes_anunciante")
    private Integer negociationsNumber;

    public UserProfile() {
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCountryState() {
        return countryState;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDtaNasc() {
        return dtaNasc;
    }

    public String getFormattedDtaNasc() {
        String result = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        result = sdf.format(dtaNasc);

        return result;
    }

    public void setDtaNasc(Date dtaNasc) {
        this.dtaNasc = dtaNasc;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getBase64Avatar() {
        if (avatar != null) {
            String result = "data:image/jpg;base64,";
            result += Base64.getEncoder().encodeToString(avatar);
            return result;
        } else {
            return "";
        }
    }

    public Double getAdvertiserMark() {
        return advertiserMark;
    }

    public void setAdvertiserMark(Double advertiserMark) {
        this.advertiserMark = advertiserMark;
    }

    public Integer getNegociationsNumber() {
        return negociationsNumber;
    }

    public void setNegociationsNumber(Integer negociationsNumber) {
        this.negociationsNumber = negociationsNumber;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "idPerfil=" + idPerfil + ", nameUser=" + nameUser + ", lastnameUser=" + lastnameUser + ", cpf=" + cpf + ", rg=" + rg + ", countryState=" + countryState + ", city=" + city + ", cep=" + cep + ", phone=" + phone + ", dtaNasc=" + dtaNasc + ", avatar=" + avatar + ", advertiserMark=" + advertiserMark + ", negociationsNumber=" + negociationsNumber + '}';
    }

}
