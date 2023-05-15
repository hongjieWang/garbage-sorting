package com.garbage.sorting.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.garbage.sorting.domain.GarbageCategory;
import com.garbage.sorting.service.GarbageCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanghongjie
 */
@RestController
@RequestMapping("/garbageCategory")
public class GarbageCategoryController {

    @Resource
    private GarbageCategoryService garbageCategoryService;

    @GetMapping
    public List<GarbageCategory> getAll() {
        return garbageCategoryService.list();
    }

    /**
     * 根据编号查询分类信息
     *
     * @param categoryNo 分类编号
     * @return
     */
    @GetMapping("/queryByCategoryNo")
    public JSONObject queryByCategoryNo(String categoryNo) {
        LambdaQueryWrapper<GarbageCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GarbageCategory::getCategoryNo, categoryNo);
        GarbageCategory one = garbageCategoryService.getOne(wrapper);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("data", one);
        return jsonObject;
    }

}
