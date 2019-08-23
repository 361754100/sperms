package com.smart.sperms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Descript 自定义配置-实体类映射
 * @Author mojianzhang
 * @Date 2018-07-17 11:15:48
 * @Version 1.0
 */
@Configuration
public class PropertiesConfig {

    @Value("${encrypt.xxtea.key_smart}")
    private String xxtea_key_smart;

    public String getXxtea_key_smart() {
        return xxtea_key_smart;
    }

    public void setXxtea_key_smart(String xxtea_key_smart) {
        this.xxtea_key_smart = xxtea_key_smart;
    }
}
