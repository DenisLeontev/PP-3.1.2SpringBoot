package ru.leontev.springboot.PP312.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leontev.springboot.PP312.dao.UserDao;
import ru.leontev.springboot.PP312.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional(readOnly = true)
    public User show(long id) {
        return userDao.show(id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        return userDao.getList();
    }

}
