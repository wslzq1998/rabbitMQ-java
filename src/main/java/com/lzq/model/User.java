package com.lzq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //主键id
    private Integer id;
    //用户名
    private String username;
    //登录密码
    private String password;

    private List<Role> roles;
}
