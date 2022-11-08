package com.tmdds.book.springboot.domain.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 로그인 컨트롤러
 * 1. 로그인 페이지 구현.
 * 2. 자체 로그인과, 타 사이트 로그인을 어떻게 구별해서 처리해야 하지
 */

@Controller

public class MemberController {


    @RequestMapping("/member/register")
    public String login(){
        return "register";
    }

}
