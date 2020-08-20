package com.example.MCord.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "userLogin")
//lombok

@Entity  //绑定表
@Data
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  //添加完成后 user.set 不需要加id即可
    private Long id ;
    private String userName;
    private String password;

}
