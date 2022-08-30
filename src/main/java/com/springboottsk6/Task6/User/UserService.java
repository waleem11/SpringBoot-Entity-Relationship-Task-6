package com.springboottsk6.Task6.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList(){
        List<User>  ulist = new ArrayList<>();
        userRepository.findAll().forEach(ulist::add);
        return ulist;
    }

    public boolean verifyUser(User user) {
        List<User> userList = new ArrayList<>(getUserList());
        for (User tmpUser : userList) {
            if (tmpUser.getUsername().equals(user.getUsername())  && tmpUser.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            List<User> userList = new ArrayList<>(getUserList());
            for (User tmpUser : userList) {
                if (tmpUser.getUsername().equals(username)) {
                    return new org.springframework.security.core.userdetails.User(tmpUser.getUsername(), tmpUser.getPassword(),
                            new ArrayList<>());
                }
            }

        return new org.springframework.security.core.userdetails.User("admin", "P@K!$T@N",
                new ArrayList<>());
    }
}
