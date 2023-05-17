package com.garbage.sorting.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.garbage.sorting.config.WeCharConfig;
import com.garbage.sorting.service.WeCharService;
import okhttp3.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

/**
 * 微信登录
 *
 * @author wanghongjie
 */
@Service
public class WeCharServiceImpl implements WeCharService {

    @Resource
    private WeCharConfig weCharConfig;
    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();
    private static final String HTTP_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    @Override
    public String getOpenId(String code) {
        String httpUrl = HTTP_URL.replace("APPID", weCharConfig.getAppId()).replace("SECRET", weCharConfig.getSecret()).replace("JSCODE", code);
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder().url(httpUrl).get().addHeader("Content-Type", "application/json").addHeader("Accept", "application/json").build();
        Response response = null;
        try {
            response = HTTP_CLIENT.newCall(request).execute();
            if (Objects.nonNull(response.body())) {
                JSONObject jsonObject = JSONObject.parseObject(response.body().string());
                System.out.println(jsonObject.toJSONString());
                return jsonObject.getString("openid");
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
