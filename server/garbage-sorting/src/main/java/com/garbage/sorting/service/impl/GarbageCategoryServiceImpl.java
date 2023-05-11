package com.garbage.sorting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garbage.sorting.domain.GarbageCategory;
import com.garbage.sorting.mapper.GarbageCategoryMapper;
import com.garbage.sorting.service.GarbageCategoryService;
import org.springframework.stereotype.Service;

/**
 * @author wanghongjie
 */
@Service
public class GarbageCategoryServiceImpl extends ServiceImpl<GarbageCategoryMapper, GarbageCategory> implements GarbageCategoryService {
}
