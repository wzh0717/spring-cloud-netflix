package com.wangzh.sample.feign.client.controller;

import com.wangzh.sample.feign.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wangzh
 * @Date: 2019/08/10 13:46
 */

@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    private HelloService helloService;


    @GetMapping("/user")
    public String getUser(@RequestParam(name = "name") String name) {
        return helloService.getUser(name);
    }
}
