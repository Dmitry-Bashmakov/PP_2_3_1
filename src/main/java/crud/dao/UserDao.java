package crud.dao;

import crud.model.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getAllUsers();

    UserEntity getUserById(int id);

    void createUser(UserEntity user);

    void update(int id, UserEntity user);

    void delete(int id);
}
