package com.smart.sperms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement // 开启事务管理
@MapperScan("com.smart.sperms.dao.mapper")
public class SpermsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpermsApplication.class, args);
    }

}
