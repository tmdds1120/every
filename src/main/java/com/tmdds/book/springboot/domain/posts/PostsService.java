package com.tmdds.book.springboot.domain.posts;


import com.tmdds.book.springboot.web.dto.PostsListResponseDto;
import com.tmdds.book.springboot.web.dto.PostsResponseDto;
import com.tmdds.book.springboot.web.dto.PostsSaveRequestDto;
import com.tmdds.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Transient;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    //여기서는 데이터가 가공되서 매개변수로 들어온 상태인가? 들어오나?
    // requestDto 에서 title, content? 를 받도록하는?
    // 생성자를 하나만 만들어서 기본생성자 x .
    // 그렇게 되면 null 이든 뭐든 t/content 에 값이 있다는걸 전재로 가공해서 받아오나
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        // 그냥 엔티티 객체에서 생성자를 통해서 값을 넘겨주는거 밖에 없고
        // jpa repo 에서 update 메서드 생성 하지도 않았는데 이과정이 필요한 이유가 뭐지
        // jpa의 영컨이 entity 객체인 posts 의 update 메서드를 통해서 변경된 엔티티의 값의
        // 변경을 감지해서,, 트랜잭션이 끝나는 시점에 이거를 해당 테이블에 변경내역을 반영한다

        //==> entity 객체의 값만 변경하면? update 를 날릴 필요가 없다
        // 더티 체크 개념
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity =postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findByOOrderById(){
        return postsRepository.findByOOrderById().stream()
                .map(PostsListResponseDto :: new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(posts);
    }

}
