package com.vladislav.services;

import com.vladislav.DAO.UserDAO;
import com.vladislav.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserDAO userDAOImpl;

    public UserService(UserDAO userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @Transactional
    public void createUser(User user) {
        userDAOImpl.createUser(user);
    }

    public List<User> findAllUsers(){
        return userDAOImpl.findAllUsers();
    }

    public User findUserById(Long id) {
        return userDAOImpl.findUserById(id);
    }
    @Transactional
    public void deleteUserById(Long id) {
        userDAOImpl.deleteUserById(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDAOImpl.updateUser(user);
    }
}
