package com.tmdds.book.springboot.web;


import com.tmdds.book.springboot.domain.posts.PostsService;
import com.tmdds.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


//  두개를 어떻게 인지하고 써야되지
//페이지에 관련된 컨트롤러는 모두 indexController 에서 관리
@Controller
@RequiredArgsConstructor
public class IndexController {

//    @Autowired
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findByOOrderById());

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
