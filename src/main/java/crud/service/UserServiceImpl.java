package crud.service;

import crud.dao.UserDao;
import crud.dao.UserDaoImpl;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {this.dao = dao;}

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        dao.createUser(user);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        dao.update(id, user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
