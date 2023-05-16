package com.garbage.sorting.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 垃圾分类配置
 *
 * @author wanghongjie
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "garbage")
public class GarbageConfig {
    private String clientId;
    private String clientSecret;
}
