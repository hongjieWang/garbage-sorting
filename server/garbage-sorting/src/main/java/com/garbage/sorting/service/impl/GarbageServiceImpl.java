package com.garbage.sorting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garbage.sorting.domain.Garbage;
import com.garbage.sorting.mapper.GarbageMapper;
import com.garbage.sorting.service.GarbageService;
import org.springframework.stereotype.Service;

/**
 * @author wanghongjie
 */
@Service
public class GarbageServiceImpl extends ServiceImpl<GarbageMapper, Garbage> implements GarbageService {
}
