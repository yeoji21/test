package com.study.springmvc.web.frontcontroller.v3.controller;

import com.study.springmvc.domain.member.Member;
import com.study.springmvc.domain.member.MemberRepository;
import com.study.springmvc.web.frontcontroller.ModelView;
import com.study.springmvc.web.frontcontroller.v3.ControllerV3;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository;

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
