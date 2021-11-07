package com.study.springmvc.web.frontcontroller.v3.controller;

import com.study.springmvc.domain.member.Member;
import com.study.springmvc.domain.member.MemberRepository;
import com.study.springmvc.web.frontcontroller.ModelView;
import com.study.springmvc.web.frontcontroller.v3.ControllerV3;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository;

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
