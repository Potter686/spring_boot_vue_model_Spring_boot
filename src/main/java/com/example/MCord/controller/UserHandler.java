package com.example.MCord.controller;

import com.example.MCord.entity.User;
import com.example.MCord.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page , @PathVariable("size") Integer size ){
//       分页
        Pageable pageable = PageRequest.of(page-1,size);
        return userRepository.findAll(pageable);
    }
    @PostMapping("/save")
    //RequestBody 将前端json转成java对象
    public String save(@RequestBody User user){
        User user1 =  userRepository.save(user);

        boolean result =  StringUtils.isEmpty(user1);
        if (!result ){
            return "success";
        }
        else
            return "error";
    }
    @GetMapping("/findById/{id}")
    public User findBuId(@PathVariable("id") Long id ){
//        System.out.println("这里是ID:"+id);
        return userRepository.findById(id).get();
    }

    @PutMapping("update")
    public String update(@RequestBody User user){
        User user1 =  userRepository.save(user);
        boolean result =  StringUtils.isEmpty(user1);
        if (!result ){
            return "success";
        }
        else
            return "error";
    }
    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
