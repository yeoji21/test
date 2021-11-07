package com.study.springmvc.web.frontcontroller.v3;

import com.study.springmvc.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
