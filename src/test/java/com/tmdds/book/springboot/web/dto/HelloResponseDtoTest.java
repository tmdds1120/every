package com.tmdds.book.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    public void 롬복_테스트기능(){
        String name ="test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getName()).isEqualTo(name);


    }
}