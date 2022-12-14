package web.DAO;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAO {

    private final EntityManager manager;

    public UserDAO(EntityManagerFactory entityManagerFactory) {
        manager = entityManagerFactory.createEntityManager();
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
