package com.lzq.springSecurityConfig;

import com.lzq.service.serviceImpl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/page1").hasRole("ADMIN")
                .antMatchers("/page2").hasRole("USER");
        // 配置登录功能
        http.formLogin().usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userLogin");
        // 注销成功跳转首页
        http.logout().logoutSuccessUrl("/page1");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
    }
    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService())
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public UserDetailServiceImpl userDetailService (){
        return new UserDetailServiceImpl () ;
    }
    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
