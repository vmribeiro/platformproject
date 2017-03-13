package ptf.model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserProfile.class)
public abstract class UserProfile_ {

	public static volatile SingularAttribute<UserProfile, String> nameUser;
	public static volatile SingularAttribute<UserProfile, String> lastnameUser;
	public static volatile SingularAttribute<UserProfile, String> city;
	public static volatile SingularAttribute<UserProfile, Date> dtaNasc;
	public static volatile SingularAttribute<UserProfile, byte[]> avatar;
	public static volatile SingularAttribute<UserProfile, String> cep;
	public static volatile SingularAttribute<UserProfile, Double> advertiserMark;
	public static volatile SingularAttribute<UserProfile, Long> idPerfil;
	public static volatile SingularAttribute<UserProfile, String> rg;
	public static volatile SingularAttribute<UserProfile, String> phone;
	public static volatile SingularAttribute<UserProfile, String> cpf;
	public static volatile SingularAttribute<UserProfile, Integer> negociationsNumber;
	public static volatile SingularAttribute<UserProfile, String> countryState;

}

