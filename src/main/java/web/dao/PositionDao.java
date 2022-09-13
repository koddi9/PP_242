package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Position;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PositionDao {
    @PersistenceContext(unitName = "getEntityManagerFactory")
    private EntityManager entityManager;


    public void add(Position position) {
        entityManager.persist(position);
    }


    @SuppressWarnings("unchecked")
    public List<Position> getPositions() {
        return entityManager.createQuery("from Position").getResultList();
    }


    public void delete(long id) {
        entityManager.remove(getPosition(id));
    }


    public void update(Position position) {
        entityManager.merge(position);
    }


    public Position getPosition(long id) {
        return entityManager.find(Position.class,id);
    }
}
