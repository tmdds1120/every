package com.tmdds.book.springboot.web;


import com.tmdds.book.springboot.domain.posts.PostsService;
import com.tmdds.book.springboot.web.dto.PostsResponseDto;
import com.tmdds.book.springboot.web.dto.PostsSaveRequestDto;
import com.tmdds.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {

   private final PostsService postsService;



    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){


        return postsService.save(requestDto);
    }

    //postupdate 클래스 생성 , update 생성
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    //postsresponseDto 추가 , findById 추가
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
