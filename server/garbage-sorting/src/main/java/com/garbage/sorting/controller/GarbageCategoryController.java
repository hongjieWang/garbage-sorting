package com.garbage.sorting.controller;

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

}
