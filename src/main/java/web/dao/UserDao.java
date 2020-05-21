package web.dao;

import web.model.User;
import java.util.*;

public interface UserDao {
    User getUserById(int id);
    List<User> getAllUsers();
    void deleteUser(int id);
    void updateUser(User user);
    void insertUser(User user);
}
