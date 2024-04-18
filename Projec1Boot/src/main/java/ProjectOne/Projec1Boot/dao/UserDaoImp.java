package ProjectOne.Projec1Boot.dao;

import ProjectOne.Projec1Boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@ComponentScan(value = "ProjectOne.Projec1Boot")
public class UserDaoImp implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("select u from User u",User.class ).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void dropUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void changeUser(User user) {
        entityManager.merge(user);

    }
}
