package com.garbage.sorting.controller;

import com.alibaba.fastjson2.JSONObject;
import com.garbage.sorting.service.BaiduService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanghongjie
 */
@RestController
@RequestMapping("/baidu")
public class BaiDuController {

    @Resource
    private BaiduService baiduService;

    @GetMapping("/getToken")
    public JSONObject getToken() {
        String token = baiduService.getToken();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", token);
        return jsonObject;
    }
}
