package com.garbage.sorting.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考题内容
 *
 * @author wanghongjie
 */
@Data
public class ExamContent implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 试卷ID
     */
    private Long examId;
    /**
     * 正确答案
     */
    private String successAnswer;
    /**
     * 选择答案
     */
    private String chooseAnswer;
    /**
     * 题目顺序
     */
    private Integer examOrder;
    /**
     * 题目名称
     */
    private String name;
    /**
     * 题库ID
     */
    private Long garbageId;

    /**
     * 创建时间
     */
    private Date createDate;
}
