package com.uwjx.oauthserver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 14:06
 */
@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.warn("登录的用户名:{}" , username);
        if(username.startsWith("TEL_")){
            //验证码登录
            String phone = username.substring(3, username.length());
            String smsCode = "111";//根据手机号获取真实的验证码
            String password = passwordEncoder.encode(smsCode);
            User user = new User(phone , password , AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
            return user;
        }else {
            //密码登录
            String password = passwordEncoder.encode("123");
            User user = new User(username , password , AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
            return user;
        }

    }
}
