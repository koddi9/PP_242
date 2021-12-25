package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void delete(long id);
    void update(User user);
    User getUser(long id);
    User getUserByName(String username);
}
