package com.tmdds.book.springboot.domain.posts;


import com.tmdds.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content,String author){
        this.title =title;
        this.content = content;
        this.author =author;
    }

    // 포스트에 따로 만들어준 이유?,, 어차피 서비스에서 비즈니스 로직을 할텐데
    // 엔티티에서 이렇게 만들어준게?
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
