package com.uin.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanglufei
 * @description: 类似于client 客户端
 * @date 2022/4/11/8:05 PM
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private ConsumerTokenServices tokenServices;

    /**
     * 获取当前user
     *
     * @param authentication
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/11 8:09 PM
     */
    @RequestMapping("/test")
    //authentication 认证
    public String test() {
        return "success!";
    }





}
