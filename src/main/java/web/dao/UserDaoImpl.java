package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository("daoImpl")
public class UserDaoImpl implements UserDao {
    List<User> defaultUsers = new ArrayList<>();

    @PersistenceContext(unitName = "getEntityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User getUserByName(String username) {
        if(defaultUsers.size()==0) {
//            setDefaultUsers();
        }
        Optional<User> user = Optional.of(
                (User)entityManager.createQuery("from User as user where user.username=?1")
                        .setParameter(1,username).getResultList().get(0)
        );

       if(!user.isPresent()){
           return null;
       }
       return user.get();
    }

    private void setDefaultUsers(){
        if(defaultUsers.size()==0) {
            Role adminRole =new Role("ROLE_ADMIN");
            entityManager.persist(adminRole);
            Role userRole=new Role("ROLE_USER");
            entityManager.persist(userRole);
            defaultUsers.add(new User("Nick", "Kad", (byte) 24, Set.of(adminRole),"nikkad","123321"));
            defaultUsers.add(new User("Ulya", "Kad", (byte) 26,Set.of(adminRole,userRole),"ulkad","123321"));
            defaultUsers.add(new User("Den", "Kad", (byte) 29,Set.of(userRole),"denkad","123321"));
            for (User user : defaultUsers) {
                add(user);
            }
        }
    }
}
