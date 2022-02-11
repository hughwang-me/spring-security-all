package com.uwjx.oauthresourceusermanager.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.oauthresourceusermanager.domain.JwtToken;
import com.uwjx.oauthresourceusermanager.domain.UserLoginDomain;
import com.uwjx.oauthresourceusermanager.network.OkHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 15:56
 */
@RestController
@RequestMapping(value = "account")
@Slf4j
public class AccountController {

    @Autowired
    OkHttpService okHttpService;

    @PostMapping(value = "login")
    public JwtToken login(@RequestBody UserLoginDomain loginDomain) throws IOException {
        log.warn("请求参数:{}", JSON.toJSONString(loginDomain));
        String url = "http://localhost:8000/oauth/token";

        Map<String, String> body = new HashMap<>();
        body.put("grant_type", "password");


        switch (loginDomain.getLoginType()) {
            case SMS:
                body.put("username", "TEL_" + loginDomain.getUsername());
                body.put("password", loginDomain.getSmsCode());
                break;
            case PASSWORD:
                body.put("username", loginDomain.getUsername());
                body.put("password", loginDomain.getPassword());
                break;
            default:
                break;
        }
        String response = okHttpService.post(url, body);
        log.warn("响应结果:{}", response);
        JwtToken jwtToken = JSON.parseObject(response, JwtToken.class);
        return jwtToken;
    }
}
