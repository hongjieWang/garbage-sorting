package com.garbage.sorting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garbage.sorting.domain.Exam;
import com.garbage.sorting.mapper.ExamMapper;
import com.garbage.sorting.service.ExamService;
import org.springframework.stereotype.Service;

/**
 * @author wanghongjie
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
}
