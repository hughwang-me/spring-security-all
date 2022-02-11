package com.uwjx.oauthserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 14:28
 */
@RestController
@Slf4j
@RequestMapping(value = "test")
public class TestController {

    @GetMapping(value = "t1")
    public String t1(){
        log.warn("test - t1");
        return "test - t1";
    }
}
