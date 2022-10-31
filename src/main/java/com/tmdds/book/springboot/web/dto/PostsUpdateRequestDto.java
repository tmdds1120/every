package com.tmdds.book.springboot.web.dto;

//업데이트 데이터 가공처리

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;
// 빌더 어노테이션 레퍼런스나 찾아보자
    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content =content;
    }
    //==> 이후에 Posts 에서 update 메서드 생성

    // setter 가 아니라
    // 빌더 패턴으로 바꿔서 전송하는 이유
    // 편해서 였던가
    // sett으로 하면은 번거로워서? 다른이유는 없던가?
    //따로 빌더 어노테이션을 해준이유가 있나
    // 이렇게 생성자를 통해서 넘겨주면
    // 빌더패턴 build.builder 를 쓸 필요없으니까 붙일 필요도없을텐데
    // 명시적으로 보이고 싶어서 그런건가
}
