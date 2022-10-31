package com.tmdds.book.springboot.domain.posts;

import com.tmdds.book.springboot.web.dto.PostsSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PostsServiceTest {
    @LocalServerPort
    private int port;

//    @Autowired
//    private TestRestTemplate restTemplate;
    // 실제 테스트가 아닌 웹 패키지에 이 restTemplate 의 객체를 안 넣어줘서 주입이 안되는듯
    // 컨트롤러에서 쓰는거라서 안되ㅡㄴ건가




}