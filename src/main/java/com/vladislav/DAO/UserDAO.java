package com.vladislav.DAO;

import com.vladislav.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDAO {

    void createUser(User user);
    List<User> findAllUsers();


    User findUserById(Long id);

    void deleteUserById(Long id);

    void updateUser(User user);
}
