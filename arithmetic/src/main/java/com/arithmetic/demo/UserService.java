package com.arithmetic.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> AllUser();

    public int Update(User user);

}
