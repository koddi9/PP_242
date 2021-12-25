package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext(unitName = "getEntityManagerFactory")
    EntityManager entityManager;

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public Role find(int id) {
        return entityManager.find(Role.class,id);
    }
}
