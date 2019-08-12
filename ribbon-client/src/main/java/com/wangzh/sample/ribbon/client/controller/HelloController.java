package com.wangzh.sample.ribbon.client.controller;

import com.wangzh.sample.ribbon.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wangzh
 * @Date: 2019/08/09 22:21
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/user")
    public String getUser(@RequestParam String name) {
        return helloService.getUser(name);
    }
}
