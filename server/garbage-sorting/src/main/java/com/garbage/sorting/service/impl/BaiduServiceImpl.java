package com.garbage.sorting.service.impl;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.garbage.sorting.service.BaiduService;
import lombok.SneakyThrows;
import okhttp3.*;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

/**
 * @author wanghongjie
 */
@Service
public class BaiduServiceImpl implements BaiduService {

    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    private static final String TOKEN_URL = "https://aip.baidubce.com/oauth/2.0/token?client_id=8O6iDRorKU3bZEhSYyOs1QLe&client_secret=YpjD0PjuD61DQVBSjFeRy7grbYZMKdBe&grant_type=client_credentials";


    @Override
    public String getToken() {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder().url(TOKEN_URL).method("POST", body).addHeader("Content-Type", "application/json").addHeader("Accept", "application/json").build();
        Response response = null;
        try {
            response = HTTP_CLIENT.newCall(request).execute();
            if (Objects.nonNull(response.body())) {
                JSONObject jsonObject = JSONObject.parseObject(response.body().string());
                return jsonObject.getString("access_token");
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows(Exception.class)
    @Override
    public String advancedGeneral(String imgParam) {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        imgParam = URLEncoder.encode(imgParam, "UTF-8");
        RequestBody body = RequestBody.create(mediaType, "image=".concat(imgParam));
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general?access_token=" + getToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "application/json")
                .build();
        Response response = null;
        try {
            response = HTTP_CLIENT.newCall(request).execute();
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONArray result = jsonObject.getJSONArray("result");
            return result.getJSONObject(0).getString("keyword");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
