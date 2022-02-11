package com.uwjx.oauthresourceusermanager.network;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 16:06
 */
@Service
@Slf4j
public class OkHttpService {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public String post(String url, Map<String, String> body) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        body.forEach((key, value) -> {
            builder.add(key, value);
        });
        RequestBody formBody = builder.build();
        String Authorization = "Basic Y2xpZW50LTAxOjEyMzQ1Ng==";
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", Authorization)
                .post(formBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}
