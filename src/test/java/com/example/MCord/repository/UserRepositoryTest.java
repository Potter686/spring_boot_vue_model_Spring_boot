package com.example.MCord.repository;

import com.example.MCord.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static jdk.nashorn.internal.objects.NativeString.length;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll(){
        System.out.println(userRepository.findAll());

    }
    @Test
    void save(){
        User user = new User();
        user.setUserName("1234");
        user.setPassword("1234");

        User test = userRepository.save(user);
        System.out.println(test.getId()!=null);

    }
}
