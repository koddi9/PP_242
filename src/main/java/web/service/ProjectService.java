package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.ProjectDao;
import web.model.Project;

import java.util.List;

@Service
public class ProjectService {
    ProjectDao dao;

    @Autowired
    public ProjectService(ProjectDao dao) {
        this.dao = dao;
    }

    public ProjectService() {
    }

    @Transactional
    public List<Project> getProjects() {
        return dao.getProjects();
    }

    @Transactional
    public void add(Project project) {
        dao.add(project);
    }

    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    @Transactional
    public void update(Project project) {
        dao.update(project);
    }

    @Transactional
    public Project getProject(long id) {
        return dao.getProject(id);
    }
}
