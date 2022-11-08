package com.tmdds.book.springboot.config;

import com.tmdds.book.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;


    /**
     *
     * handlerMethodArgumentResolver 는 항상 WebMvcConfigurer 의 addArgumentResolver 를 통해서 추가해야 한다.
     * 다른 Handler-MethodArgumentResolver 가 필요하다면 같은 방식으로 추가해 주면 됩니다
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);

    }
}
