package com.uwjx.oauthresourceusermanager.domain;

import lombok.Data;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 16:23
 */
@Data
public class JwtToken {

    private String access_token;
    private String token_type;
    private Long expires_in;
    private String scope;
    private String key;
    private String jti;
}
