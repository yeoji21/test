package com.study.springmvc.web.frontcontroller.v1.controller;

import com.study.springmvc.domain.member.Member;
import com.study.springmvc.domain.member.MemberRepository;
import com.study.springmvc.web.frontcontroller.v1.ControllerV1;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Controller
@NoArgsConstructor
public class MemberListControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
