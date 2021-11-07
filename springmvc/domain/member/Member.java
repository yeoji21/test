package com.study.springmvc.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String username;

    private int age;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}


