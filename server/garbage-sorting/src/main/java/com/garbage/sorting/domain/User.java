package com.garbage.sorting.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author wanghongjie
 */
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * openId
     */
    private String openId;
    /**
     * 昵称
     */
    private String nackName;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 所属社区
     */
    private String community;
    /**
     * 头像
     */
    private String profile;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 积分
     */
    private Integer integral;
    /**
     * 创建时间
     */
    private Date createTime;
}
