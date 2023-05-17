package com.garbage.sorting.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户是否注册
 *
 * @author wanghongjie
 */
@Data
public class UserModel implements Serializable {
    private String openId;
    private Boolean isRegister;
}
