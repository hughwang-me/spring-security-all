package com.uwjx.oauthresourcebookmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 15:33
 */
@RestController
@RequestMapping(value = "book")
@Slf4j
public class BookController {

    @GetMapping(value = "list")
    public String list(){
        log.warn("book - list");
        return "book list";
    }
}
