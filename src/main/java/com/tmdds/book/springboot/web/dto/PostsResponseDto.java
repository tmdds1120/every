package com.tmdds.book.springboot.web.dto;


import com.tmdds.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        // 엔티티에 맞게 데이터를 변환해서 전달해주는건데
        // 이거를 응답해주는거고?
        // 그러면은 엔티티에서 설정한 규칙들을 어떻게 검증하고 관리하지?
        // 애초에 엔티티에서 받아서 하는거니까
        // 엔티티 에서 설정한 규약에 맞게 데이터가 들어온거를
        // api 에서 쓰기 좋게 가공하는거를 dto 에서 하는거지
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }
}
