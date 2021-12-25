package web.service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
//    List<Car> getCarsList(String count);
    List<User> getUsersList(String count);
    void add(User user);
    void delete(long id);
    void update(User user);
    User getUser(long id);
    User getUserByName(String username);
}
