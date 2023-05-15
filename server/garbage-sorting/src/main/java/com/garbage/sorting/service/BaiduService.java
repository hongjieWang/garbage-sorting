package com.garbage.sorting.service;

/**
 * 百度API
 *
 * @author wanghongjie
 */
public interface BaiduService {
    /**
     * 获取token
     *
     * @return
     */
    String getToken();

    public String advancedGeneral(String imgParam);
}
