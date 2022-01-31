package crud.service;

import crud.dao.IGenericDao;
import crud.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class UserJPAService implements UserService {

    IGenericDao<UserEntity> dao;

    @Autowired
    public void setDao(IGenericDao<UserEntity> daoToSet) {
        dao = daoToSet;
        dao.setClazz(UserEntity.class);
    }

//    @Transactional
    @Override
    public List<UserEntity> getAllUsers() {
        return dao.findAll();
    }

//    @Transactional
    @Override
    public UserEntity getUserById(int id) {
        return dao.findOne(id);
    }

//    @Transactional
    @Override
    public void createUser(UserEntity user) {
        dao.create(user);
    }

//    @Transactional
    @Override
    public void update(int id, UserEntity user) {
        dao.update(user);
    }

//    @Transactional
    @Override
    public void delete(int id) {
        dao.deleteById(id);
    }
}
