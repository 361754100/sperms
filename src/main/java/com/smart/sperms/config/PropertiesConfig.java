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

//    @Value("${tcpserver.port}")
    private int serverport;

//    @Value("${version}")
    private String version;

    public int getServerport() {
        return serverport;
    }

    public void setServerport(int serverport) {
        this.serverport = serverport;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
