package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.PositionDao;
import web.model.Position;

import java.util.List;

@Service
public class PositionService {
    PositionDao dao;

    @Autowired
    public PositionService(PositionDao dao) {
        this.dao = dao;
    }

    public PositionService() {
    }

    @Transactional
    public List<Position> getPositions() {
        return dao.getPositions();
    }

    @Transactional
    public void add(Position position) {
        dao.add(position);
    }

    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    @Transactional
    public void update(Position position) {
        dao.update(position);
    }

    @Transactional
    public Position getPosition(long id) {
        return dao.getPosition(id);
    }
}
