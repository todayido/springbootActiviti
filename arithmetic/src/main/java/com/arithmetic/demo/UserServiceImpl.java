package com.arithmetic.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> AllUser() {

        return userDao.AllUser();
    }

    @Override
    public int Update(User user) {
        return userDao.Update(user);
    }
}
