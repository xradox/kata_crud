package web.services;

import org.springframework.stereotype.Service;
import web.DAO.UserDAO;
import web.models.User;
import java.util.List;

@Service
public class UserService {

    private final UserDAO dao;

    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public User getUser(int id) {
        System.out.println();
        return  dao.getUser(id);
    }

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    public void updateUser(User updated) {
        dao.updateUser(updated);
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }
}
