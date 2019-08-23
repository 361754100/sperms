package com.smart.sperms.api;

import java.io.Serializable;

/**
 * 103 消息体
 */
public class DataBody103 implements Serializable {

    private int type;

    private int count;

    private String image;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
