package com.lzq.service.serviceImpl;

import com.lzq.dao.UserRoleDao;
import com.lzq.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRoleDao userRoleDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //获取用户的角色权限
        com.lzq.model.User user = userRoleDao.selectByUserName(s);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>() ;

        /*
         * Spring Boot 2.0 版本踩坑
         * 必须要 ROLE_ 前缀， 因为 hasRole("LEVEL1")判断时会自动加上ROLE_前缀变成 ROLE_LEVEL1 ,
         * 如果不加前缀一般就会出现403错误
         * 在给用户赋权限时,数据库存储必须是完整的权限标识ROLE_LEVEL1
         */
        if(user!=null&&user.getRoles().size()>0){
            for(Role role:user.getRoles()){
                grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
            }
        }

        return new User(s,user.getPassword(),grantedAuthorityList);
    }
}
