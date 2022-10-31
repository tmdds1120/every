package com.tmdds.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository<T, ID> T: 엔티티 타입, ID
public interface PostsRepository extends JpaRepository<Posts,Long> {
    //jpaRepository 를 기본적으로 상속 받는인터페이스
    //postsRepository 를 만들었기 때문에
    // 엔티티 타입, Posts, pk의 타입 Long 을 기반으로
    // 등록 수정 조회 같은 기본적인 쿼리문 작성 x 해도 jpa 에서 처리 가능하게 해준다

    //query 어노테이션 공부
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findByOOrderById();
}
