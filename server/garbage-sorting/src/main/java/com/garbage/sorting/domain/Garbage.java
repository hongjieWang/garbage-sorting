package com.garbage.sorting.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 垃圾分类数据
 *
 * @author wanghongjie
 */
@Data
public class Garbage implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String garbageName;
    private String garbageCategoryNo;
    @TableField(exist = false)
    private GarbageCategory garbageCategory;
}
