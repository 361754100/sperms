package com.smart.sperms;

import com.smart.sperms.common.SpringContext;
import com.smart.sperms.job.QuartzFactory;
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

        QuartzFactory quartzFactory = SpringContext.getBean(QuartzFactory.class);
        quartzFactory.execute();
    }

}
