package com.garbage.sorting.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 分类类型
 *
 * @author wanghongjie
 */
@Data
public class GarbageCategory implements Serializable {
    private Long id;
    private String categoryNo;
    private String categoryName;
    private String imageUrl;
    private String categoryExplain;
    private String categoryRequire;
    private String categoryCommon;
    private String bgIcon;
    private String bgItem;
    private String color;
}
