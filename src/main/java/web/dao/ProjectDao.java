package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectDao {
    @PersistenceContext(unitName = "getEntityManagerFactory")
    private EntityManager entityManager;


    public void add(Project project) {
        entityManager.persist(project);
    }


    @SuppressWarnings("unchecked")
    public List<Project> getProjects() {
        return entityManager.createQuery("from Project").getResultList();
    }


    public void delete(long id) {
        entityManager.remove(getProject(id));
    }


    public void update(Project project) {
        entityManager.merge(project);
    }


    public Project getProject(long id) {
        return entityManager.find(Project.class,id);
    }
}
