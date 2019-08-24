package com.smart.sperms.api.protocol;

import java.io.Serializable;

/**
 * 112 消息体
 */
public class DataBody112 implements Serializable {

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "DataBody112{" +
                "image='" + image + '\'' +
                '}';
    }
}
