package com.garbage.sorting.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 微信小程序配置类
 *
 * @author wanghongjie
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wechar")
public class WeCharConfig {
    private String appId;
    private String secret;
}
