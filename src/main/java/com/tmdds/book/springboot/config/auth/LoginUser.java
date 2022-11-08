package com.tmdds.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
// target
// 이 어노테이션이 생성 가능한 위치를 지정한다
// PARAMETER 로 지정 했으니 메소드의 파라미터로 선언된 객체에서만 사용가능
// 이클래서 선언문에 쓸 수 있는
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

    //@interface 이 파일을 어노테이션 클래스로 지정합니다
    //LoginUser 라는 이름을 가진 어노테이션이 생성 된다



}
