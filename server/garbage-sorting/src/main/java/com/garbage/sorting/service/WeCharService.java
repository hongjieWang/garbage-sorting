package com.garbage.sorting.service;

/**
 * 微信登录
 *
 * @author wanghongjie
 */
public interface WeCharService {
    /**
     * 根据code 获取openId
     *
     * @param code code
     * @return
     */
    String getOpenId(String code);
}
