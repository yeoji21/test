package com.study.springmvc.web.frontcontroller.v4.controller;

import com.study.springmvc.domain.member.Member;
import com.study.springmvc.domain.member.MemberRepository;
import com.study.springmvc.web.frontcontroller.v4.ControllerV4;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository;

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";
    }
}
