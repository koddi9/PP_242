package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDao dao;

    @Override
    @Transactional
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Role getRole(int id) {
        return dao.find(id);
    }
}
