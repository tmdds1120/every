package com.tmdds.book.springboot.config.auth;

import com.tmdds.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final CustomUserTypesOAuth2UserService customUserTypesOAuth2UserService;
    private final CustomOAuth2UserService customOAuth2UserService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                        .authorizeRequests()
                                .antMatchers("/","/css/**","/images/**"
                                ,"/js/**").permitAll()
                        .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                        .anyRequest().authenticated()
                        .and()
                                .oauth2Login()
                                        .userInfoEndpoint()
                                                .userService(customOAuth2UserService);


//        http.formLogin()
//                .loginPage("/member/login")
//                        .failureHandler(getFailHandler())
//                                .permitAll();

        super.configure(http);
    }
}
