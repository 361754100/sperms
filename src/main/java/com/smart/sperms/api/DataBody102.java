package com.smart.sperms.api;

import java.io.Serializable;

/**
 * 102 消息体
 */
public class DataBody102 implements Serializable {

    private boolean work;

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }
}
