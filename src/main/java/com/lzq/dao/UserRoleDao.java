package com.lzq.dao;

import com.lzq.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleDao {
    User selectByUserName(String username);
}
