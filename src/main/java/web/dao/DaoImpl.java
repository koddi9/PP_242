package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("daoImpl")
public class DaoImpl implements IDao {

    @PersistenceContext(unitName = "getEntityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class,id);
    }
}
