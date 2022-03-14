package com.sb.service;

import com.sb.entity.User;
import com.sb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostConstruct
    public void initUsers() {
        User user = new User();
        user.setName("Test");
        user.setSurname("Test");

        HashMap<String, Object> additionalInf = new HashMap<>();
        additionalInf.put("favorite color", "grey");

        user.setAdditionalInformations(additionalInf);

        userRepository.save(user);

        user = new User();
        user.setName("Deneme");
        user.setSurname("Deneme");

        additionalInf = new HashMap<>();
        additionalInf.put("favorite color", "green");

        user.setAdditionalInformations(additionalInf);

        userRepository.save(user);

    }

}
