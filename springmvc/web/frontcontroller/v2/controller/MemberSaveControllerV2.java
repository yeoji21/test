package com.study.springmvc.web.frontcontroller.v2.controller;

import com.study.springmvc.domain.member.Member;
import com.study.springmvc.domain.member.MemberRepository;
import com.study.springmvc.web.frontcontroller.MyView;
import com.study.springmvc.web.frontcontroller.v2.ControllerV2;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository;

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        request.setAttribute("member", member);

        return new MyView("WEB-INF/views/save-result.jsp");
    }
}
