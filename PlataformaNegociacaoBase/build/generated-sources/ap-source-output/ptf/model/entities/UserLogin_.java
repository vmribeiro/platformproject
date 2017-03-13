package ptf.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserLogin.class)
public abstract class UserLogin_ {

	public static volatile SingularAttribute<UserLogin, String> senha;
	public static volatile SingularAttribute<UserLogin, Long> idLogin;
	public static volatile SingularAttribute<UserLogin, Integer> type;
	public static volatile SingularAttribute<UserLogin, String> email;
	public static volatile SingularAttribute<UserLogin, UserProfile> userProfile;

}

