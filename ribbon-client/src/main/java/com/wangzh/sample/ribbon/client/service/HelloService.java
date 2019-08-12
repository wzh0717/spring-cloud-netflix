package com.wangzh.sample.ribbon.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: wangzh
 * @Date: 2019/08/09 22:16
 */

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getUserError")
    public String getUser(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/user/info?name=" + name, String.class);
    }

    public String getUserError(String name) {
        return "error user msg：" + name;
    }
}
