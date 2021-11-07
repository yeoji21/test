package com.study.springmvc.web.frontcontroller.v2.controller;

import com.study.springmvc.domain.member.Member;
import com.study.springmvc.domain.member.MemberRepository;
import com.study.springmvc.web.frontcontroller.MyView;
import com.study.springmvc.web.frontcontroller.v2.ControllerV2;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository;

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
        return new MyView("WEB-INF/views/members.jsp");
    }
}
