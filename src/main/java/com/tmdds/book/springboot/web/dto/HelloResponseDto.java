package com.tmdds.book.springboot.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter@Setter
//@AllArgsConstructor
@RequiredArgsConstructor
public class HelloResponseDto {
     private final String name;
     private final int amount;

//    public HelloResponseDto(String name, int amount) {
//        this.name = name;
//        this.amount = amount;
//    }
}
