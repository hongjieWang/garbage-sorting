package com.garbage.sorting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garbage.sorting.domain.Garbage;

import java.util.List;

/**
 * @author wanghongjie
 */
public interface GarbageService extends IService<Garbage> {
    List<Garbage> genExam();
}
