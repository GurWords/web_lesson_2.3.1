package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.ImplUserDao;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class ImplUsersService implements UsersService{

    @Autowired
    private UserDao implUserDao;


    @Override
    public User getUserByID(int id) {
        return implUserDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return implUserDao.getAllUsers();
    }


    @Override
    public void deleteUser(int id) {
        implUserDao.deleteUser(id);
    }


    @Override
    public void updateUser(User user) {
        implUserDao.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
        implUserDao.insertUser(user);
    }
}
