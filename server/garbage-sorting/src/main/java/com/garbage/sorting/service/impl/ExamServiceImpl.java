package com.garbage.sorting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garbage.sorting.common.AjaxResult;
import com.garbage.sorting.domain.Exam;
import com.garbage.sorting.domain.ExamContent;
import com.garbage.sorting.domain.Garbage;
import com.garbage.sorting.mapper.ExamMapper;
import com.garbage.sorting.service.ExamContentService;
import com.garbage.sorting.service.ExamService;
import com.garbage.sorting.service.GarbageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wanghongjie
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {

    @Resource
    private GarbageService garbageService;

    @Resource
    private ExamContentService examContentService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult createExam(String openId) {
        LambdaQueryWrapper<Exam> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Exam::getOpenId, openId);
        wrapper.eq(Exam::getFinish, 0);
        Exam exam = baseMapper.selectOne(wrapper);
        if (Objects.isNull(exam)) {
            exam = this.create(openId);
        } else {
            LambdaQueryWrapper<ExamContent> contentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            contentLambdaQueryWrapper.eq(ExamContent::getExamId, exam.getId());
            List<ExamContent> list = examContentService.list(contentLambdaQueryWrapper);
            exam.setExamContents(list);
        }
        return AjaxResult.success(exam);
    }

    @Override
    public AjaxResult answerQuestions(Long examId, Integer order, String answer) {
        Exam exam = baseMapper.selectById(examId);
        if (exam.getFinish().equals(1)) {
            return AjaxResult.error("答题完成,不允许再次修改咯!");
        }
        LambdaQueryWrapper<ExamContent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ExamContent::getExamId, examId);
        wrapper.eq(ExamContent::getExamOrder, order);
        ExamContent examContent = examContentService.getOne(wrapper);
        examContent.setChooseAnswer(answer);
        examContentService.updateById(examContent);
        exam.setAtPresent(order);
        if (Objects.equals(order, exam.getTotal())) {
            exam.setFinish(1);
            calculationSource(exam);
        }
        baseMapper.updateById(exam);
        return AjaxResult.success(exam);
    }

    private void calculationSource(Exam exam) {
        LambdaQueryWrapper<ExamContent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ExamContent::getExamId, exam.getId());
        List<ExamContent> list = examContentService.list(wrapper);
        AtomicInteger success = new AtomicInteger(0);
        AtomicInteger fail = new AtomicInteger(0);
        list.forEach(examContent -> {
            if (examContent.getSuccessAnswer().equals(examContent.getChooseAnswer())) {
                success.getAndIncrement();
            } else {
                fail.getAndIncrement();
            }
        });
        exam.setCorrect(success.get());
        exam.setScore(success.get());
        exam.setError(fail.get());
    }

    private Exam create(String openId) {
        List<Garbage> garbageList = garbageService.genExam();
        Exam exam = new Exam();
        exam.setOpenId(openId);
        exam.setTotal(garbageList.size());
        exam.setAtPresent(0);
        exam.setFinish(0);
        exam.setCreateDate(new Date());
        baseMapper.insert(exam);
        List<ExamContent> examContents = new ArrayList<>();
        AtomicInteger order = new AtomicInteger(1);
        garbageList.forEach(garbage -> {
            Long id = exam.getId();
            ExamContent examContent = new ExamContent();
            examContent.setExamId(id);
            examContent.setExamOrder(order.getAndIncrement());
            examContent.setName(garbage.getGarbageName());
            examContent.setSuccessAnswer(garbage.getGarbageCategoryNo());
            examContent.setGarbageId(garbage.getId());
            examContent.setCreateDate(new Date());
            examContents.add(examContent);
        });
        examContentService.saveBatch(examContents);
        exam.setExamContents(examContents);
        return exam;
    }

}
