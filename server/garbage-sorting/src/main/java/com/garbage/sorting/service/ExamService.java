package com.garbage.sorting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garbage.sorting.common.AjaxResult;
import com.garbage.sorting.domain.Exam;

/**
 * 创建考题
 *
 * @author wanghongjie
 */
public interface ExamService extends IService<Exam> {
    /**
     * 根据OpenId 创建测试题目
     *
     * @param openId openId
     * @return
     */
    AjaxResult createExam(String openId);

    /**
     * 答题
     *
     * @param examId 试卷ID
     * @param order  题号
     * @param answer 答案
     * @return
     */
    AjaxResult answerQuestions(Long examId, Integer order, String answer);

    /**
     * 查看所有答案
     *
     * @param examId 试卷ID
     * @return
     */
    AjaxResult showExamContent(Long examId);
}
