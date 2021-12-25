package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("serviceImpl")
public class UserServiceImpl implements UserService {

    UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<User> getUsersList(String count) {
//        if (count==null){
//            count="5";
//        }
       return dao.listUsers();
//        return users.stream().limit(Integer.parseInt(count)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public User getUserByName(String username) {
        return dao.getUserByName(username);
    }

    @Override
    @Transactional
    public void add(User user) {
        dao.add(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        dao.update(user);
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return dao.getUser(id);
    }


//    @Override
//    @Transactional
//    public List<Car> getCarsList(String count) {
//        if (count==null){
//            count="5";
//        }
//        List<Car> cars = new ArrayList<>();
//        cars.add(new Car("BMW",5,"gray"));
//        cars.add(new Car("2",2,"black"));
//        cars.add(new Car("3",3,"white"));
//        cars.add(new Car("4",4,"green"));
//        cars.add(new Car("5",5,"red"));
//
//        return cars.stream().limit(Integer.parseInt(count)).collect(Collectors.toList());
//    }
}
