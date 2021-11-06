package web.dao;

import web.model.User;

import java.util.List;

public interface Idao {
    void add(User user);
    List<User> listUsers();
}
