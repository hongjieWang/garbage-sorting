package com.garbage.sorting.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.garbage.sorting.domain.Garbage;
import com.garbage.sorting.domain.GarbageCategory;
import com.garbage.sorting.service.GarbageCategoryService;
import com.garbage.sorting.service.GarbageService;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/sync")
    public String sync() throws IOException {

        HashMap<String, GarbageCategory> categoryHashMap = new HashMap<>();
        List<GarbageCategory> list = garbageCategoryService.list();
        list.forEach(garbageCategory -> {
            categoryHashMap.put(garbageCategory.getCategoryName(), garbageCategory);
        });

        List<String> strings = FileUtils.readLines(new File("/Users/wanghongjie/Desktop/rubbish_1.0.0.txt"), "UTF-8");
        strings.forEach(s -> {
            String[] split = s.split("\\|");
            String s1 = split[0];
            String s2 = split[1];
            GarbageCategory garbageCategory = categoryHashMap.get(s2);
            Garbage garbage = new Garbage();
            garbage.setGarbageName(s1);
            garbage.setGarbageCategoryNo(garbageCategory.getCategoryNo());
            garbageService.save(garbage);
        });
        return "ok";
    }

}
