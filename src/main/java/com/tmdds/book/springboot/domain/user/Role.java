package com.tmdds.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


//enum 타입도 제대로 공부 해야겠다
@RequiredArgsConstructor
@Getter
public enum Role {
    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER","일반 사용자");

    private final String key;

    private final String title;

}
