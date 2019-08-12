package com.wangzh.sample.feign.client.service;

import com.wangzh.sample.feign.client.service.fallback.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: wangzh
 * @Date: 2019/08/10 13:42
 */

@FeignClient(value = "EUREKA-CLIENT", fallback = HelloServiceHystrix.class)
@Component //component 仅作注入标记
public interface HelloService {

    @GetMapping(value = "/user/info")
    String getUser(@RequestParam(name = "name") String name);
}
