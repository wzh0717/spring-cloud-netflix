package com.wangzh.sample.feign.client.service.fallback;

import com.wangzh.sample.feign.client.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: wangzh
 * @Date: 2019/08/10 14:36
 */

@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String getUser(String name) {
        return "sorry hystrix " + name;
    }
}
