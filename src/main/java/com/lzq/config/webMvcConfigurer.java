package com.lzq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 是配置需要拦截的方法，如果遇到拦截不同的Controller，
        // 我们可以使用不同的配置，比如：/user/* 在这里是可以配置多个拦截器的。
        registry.addInterceptor(new SystemInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/*");
    }
}
