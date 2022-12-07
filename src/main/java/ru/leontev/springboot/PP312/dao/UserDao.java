package ru.leontev.springboot.PP312.dao;

import ru.leontev.springboot.PP312.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    User show(long id);

    List<User> getList();

    void update(long id, User user);

    void delete(long id);
}