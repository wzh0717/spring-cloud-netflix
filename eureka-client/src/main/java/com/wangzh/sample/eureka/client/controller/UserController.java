package com.wangzh.sample.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 服务提供端
 * @Author: wangzh
 * @Date: 2019/08/09 21:56
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @Value("${env.active}")
    private String active;

    @GetMapping("/info")
    public String getUser(@RequestParam(value = "name", defaultValue = "client") String name) {
        return "hi " + name + " , port：" + port + " active：" + active;
        // return "hi " + name + " , port：" + port;
    }
}
