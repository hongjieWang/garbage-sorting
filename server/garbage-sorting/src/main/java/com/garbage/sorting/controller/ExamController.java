package com.garbage.sorting.controller;

import com.garbage.sorting.common.AjaxResult;
import com.garbage.sorting.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 试题
 *
 * @author wanghongjie
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Resource
    private ExamService examService;

    /**
     * 创建试题
     *
     * @param openId openId
     * @return
     */
    @GetMapping("/createExam")
    public AjaxResult createExam(@RequestParam("openId") String openId) {
        return examService.createExam(openId);
    }

    @GetMapping("/answerQuestions")
    public AjaxResult answerQuestions(@RequestParam("examId") Long examId, @RequestParam("order") Integer order, @RequestParam("answer") String answer) {
        return examService.answerQuestions(examId, order, answer);
    }
}
