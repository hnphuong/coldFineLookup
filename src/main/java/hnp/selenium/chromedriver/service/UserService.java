package hnp.selenium.chromedriver.service;

import hnp.selenium.chromedriver.dto.LoginForm;
import hnp.selenium.chromedriver.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private List<User> users;
    public List<User> login(LoginForm loginForm) {
        //do stuffs
        //dump user data
        User user = new User(loginForm.getUsername(), loginForm.getPassword(), "email@javabycode.com");
        return new ArrayList<>(Collections.singletonList(user));
    }
}
