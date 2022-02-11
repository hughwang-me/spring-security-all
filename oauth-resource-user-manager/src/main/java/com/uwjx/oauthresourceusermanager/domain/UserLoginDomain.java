package com.uwjx.oauthresourceusermanager.domain;

import com.uwjx.oauthresourceusermanager.commons.LoginType;
import lombok.Data;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 15:57
 */
@Data
public class UserLoginDomain {

    private LoginType loginType;
    private String username;
    private String password;
    private String smsCode;
}
