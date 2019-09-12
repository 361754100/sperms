package com.smart.sperms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "quartz.properties")
public class QuartzProp {

    @Value("${scheduler_flag.dev_state_check}")
    private boolean dev_state_check_flag;

    @Value("${scheduler_cron.dev_state_check}")
    private String dev_state_check_cron;

    public boolean isDev_state_check_flag() {
        return dev_state_check_flag;
    }

    public void setDev_state_check_flag(boolean dev_state_check_flag) {
        this.dev_state_check_flag = dev_state_check_flag;
    }

    public String getDev_state_check_cron() {
        return dev_state_check_cron;
    }

    public void setDev_state_check_cron(String dev_state_check_cron) {
        this.dev_state_check_cron = dev_state_check_cron;
    }
}
