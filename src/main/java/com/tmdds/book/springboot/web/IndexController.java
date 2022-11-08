package com.tmdds.book.springboot.web;


import com.tmdds.book.springboot.config.auth.LoginUser;
import com.tmdds.book.springboot.config.dto.SessionUser;
import com.tmdds.book.springboot.domain.posts.PostsService;
import com.tmdds.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


//  두개를 어떻게 인지하고 써야되지
//페이지에 관련된 컨트롤러는 모두 indexController 에서 관리
@Controller
@RequiredArgsConstructor
public class IndexController {

//    @Autowired
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    // 어노테이션
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findByOOrderById());


//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); ==> @LoginUser 개선

        /**
         * 기존 httpSesson.getAttribute("user") 로 가져오던 세션 정보 값이 개선
         * 이제는 어느 컨트롤러든 @LoginUser 만 사용하여 세션 정보를 가져올 있다
         */
        if (user!= null){
            model.addAttribute("userName",user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);

//      데이터만 넘기고
        model.addAttribute("post",dto);

        return"posts-update";
    }
}
