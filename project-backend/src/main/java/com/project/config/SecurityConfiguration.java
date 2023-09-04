package com.project.config;

import com.project.entity.RestBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

/**
 * Security 配置类
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //  可以配置 表单登录
        //  拦截地址
        //  放行地址
        return http
                .authorizeHttpRequests(conf -> conf
                        //  放行auth下的所有请求
                        .requestMatchers("/api/auth/**").permitAll()
                        //  任何请求都不允许通过
                        .anyRequest().authenticated()
                )
                .formLogin(conf -> conf
                        .loginProcessingUrl("/api/auth/login")
                        //  登录失败的方法
                        .failureHandler(this::onAuthenticationFailure)
                        //  登录成功的方法
                        .successHandler(this::onAuthenticationSuccess)
                )
                .logout(conf -> conf
                        .logoutUrl("/api/auth/logout")
                        .logoutSuccessHandler(this::onAuthenticationSuccess)
                )
                .csrf(AbstractHttpConfigurer::disable)
                //  将 session改成 无状态 让Security不去处理 session
                .sessionManagement(conf -> conf
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication
    ) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(RestBean.success().asJsonString());
    }

    //  这里第三个参数变成了异常 来判断什么原因导致失败
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception
    ) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(RestBean.failure(401,exception.getMessage()).asJsonString());
    }

    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication
    ) throws IOException, ServletException {
        //  因为这里处理逻辑和登录不一样 暂时不写
    }
}
