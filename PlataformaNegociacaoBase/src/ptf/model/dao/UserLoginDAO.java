package ptf.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ptf.model.entities.UserLogin;

/**
 *
 * @author Victor Moraes Ribeiro
 */
class UserLoginDAO implements GenericDAO<UserLogin> {

    public EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("PlataformaPU");
        return emf.createEntityManager();
    }

    @Override
    public boolean save(UserLogin e) {
        boolean result = false;

        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            if (e.getIdLogin() == 0) {
                //If this entity does not exist, insert
                em.persist(e);
                result = true;
            } else {
                if (!em.contains(e)) {
                    //If this entity has to exist but was not found in db, error
                    if (em.find(UserLogin.class, e.getIdLogin()) == null) {
                        throw new Exception("Erro ao atualizar o login!");
                    }
                }
                //If this entity exists and can be found in db, update
                em.merge(e);
                em.flush();
                result = true;
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            result = false;
        } finally {
            em.clear();
            em.close();
            emf.close();
        }

        return result;
    }

    @Override
    public boolean remove(long id) {
        boolean result = false;
        EntityManager em = getEntityManager();
        UserLogin ul = em.find(UserLogin.class, id);

        try {
            em.getTransaction().begin();
            em.remove(ul);
            em.getTransaction().commit();
            result = true;
        } finally {
            em.clear();
            em.close();
            emf.close();
        }

        return result;
    }

    @Override
    public UserLogin findById(long id) {
        UserLogin result = null;
        EntityManager em = getEntityManager();

        try {
            result = em.find(UserLogin.class, id);
        } finally {
            em.clear();
            em.close();
            emf.close();
        }

        return result;
    }

    @Override
    public List<UserLogin> findAll() {
        EntityManager em = getEntityManager();
        List<UserLogin> result = null;
        try {
            Query q = em.createQuery("select u from UserLogin u");
            result = q.getResultList();
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
        return result;
    }

}
