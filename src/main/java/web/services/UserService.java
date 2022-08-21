package web.services;

import org.springframework.stereotype.Service;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserService {

    private final EntityManager manager;

    public UserService(EntityManagerFactory entityManagerFactory) {
        manager = entityManagerFactory.createEntityManager();
        for (int i = 0; i < 5; i++) {
            User user = new User("Name" + i, "LastName" + i, 1999 + i);
            saveUser(user);
        }
    }

    public List<User> getAllUsers() {
        manager.getTransaction().begin();
        TypedQuery<User> list = manager.createQuery("SELECT u from User u", User.class);
        manager.getTransaction().commit();
        return list.getResultList();
    }

    public User getUser(int id) {
        return  manager.find(User.class, id);
    }

    public void saveUser(User user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }

    public void updateUser(User updated) {
        manager.getTransaction().begin();
        manager.merge(updated);
        manager.getTransaction().commit();
    }

    public void deleteUser(int id) {
        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.remove(user);
        manager.getTransaction().commit();
    }
}
