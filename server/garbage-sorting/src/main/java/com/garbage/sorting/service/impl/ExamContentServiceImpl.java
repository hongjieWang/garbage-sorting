package com.garbage.sorting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garbage.sorting.domain.ExamContent;
import com.garbage.sorting.mapper.ExamContentMapper;
import com.garbage.sorting.service.ExamContentService;
import org.springframework.stereotype.Service;

/**
 * @author wanghongjie
 */
@Service
public class ExamContentServiceImpl extends ServiceImpl<ExamContentMapper, ExamContent> implements ExamContentService {
}
