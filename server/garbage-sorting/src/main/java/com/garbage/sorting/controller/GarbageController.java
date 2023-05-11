package com.garbage.sorting.controller;


import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.garbage.sorting.domain.Garbage;
import com.garbage.sorting.domain.GarbageCategory;
import com.garbage.sorting.service.GarbageCategoryService;
import com.garbage.sorting.service.GarbageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghongjie
 */
@RestController
@RequestMapping("/garbage")
public class GarbageController {

    @Resource
    private GarbageCategoryService garbageCategoryService;
    @Resource
    private GarbageService garbageService;

    private static final Map<String, GarbageCategory> CATEGORY = new HashMap<>();

    @PostConstruct
    public void initCategory() {
        List<GarbageCategory> list = garbageCategoryService.list();
        list.forEach(garbageCategory -> CATEGORY.put(garbageCategory.getCategoryNo(), garbageCategory));
    }

    /**
     * 精确查询
     *
     * @param name 名称
     * @return
     */
    @GetMapping("/query")
    public JSONObject query(String name) {
        LambdaQueryWrapper<Garbage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Garbage::getGarbageName, name);
        List<Garbage> list = garbageService.list(wrapper);
        list.forEach(garbage -> garbage.setGarbageCategory(CATEGORY.get(garbage.getGarbageCategoryNo())));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", list);
        return jsonObject;
    }

    /**
     * 模糊查询
     *
     * @param name 名称
     * @return
     */
    @GetMapping("/queryLike")
    public JSONObject queryLike(String name) {
        LambdaQueryWrapper<Garbage> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Garbage::getGarbageName, name);
        List<Garbage> list = garbageService.list(wrapper);
        list.forEach(garbage -> garbage.setGarbageCategory(CATEGORY.get(garbage.getGarbageCategoryNo())));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", list);
        return jsonObject;
    }

}
