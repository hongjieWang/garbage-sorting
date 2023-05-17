package com.garbage.sorting.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 考试题库
 *
 * @author wanghongjie
 */
@Data
public class Exam implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 答完
     */
    private Integer finish;
    /**
     * 总共
     */
    private Integer total;
    /**
     * 当前答第几题
     */
    private Integer atPresent;
    /**
     * 得分
     */
    private Integer score;
    /**
     * 正确数量
     */
    private Integer correct;
    /**
     * 错误数量
     */
    private Integer error;


}
