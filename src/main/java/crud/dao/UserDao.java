package crud.dao;

import crud.model.User;
import java.util.List;


public interface UserDao {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void update(int id, User user);

    void delete(int id);
}
