/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.gaozhijun.demo.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * TODO: 请添加描述
 *
 * @author gaozh
 * @date 2018/8/9
 * @since 1.0.0
 */
@RestController
public class TestController {


    @GetMapping("test")
    public String testAddHeader(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {

            System.out.println(headers.nextElement());

        }

        return "1";

    }

}
