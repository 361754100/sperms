package com.smart.sperms.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 设备启停码
 * 0：关停、1：开启
 */
public enum DevEnableEnum {

    UNKNOW(-1, "未知"),
    STOP(0, "关停"),
    TURN_ON(1, "开启");

    private int code;
    private String desc;
    private static DevEnableEnum[] values = values();

    DevEnableEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static DevEnableEnum getResult(int code) {
        DevEnableEnum result = UNKNOW;
        for(DevEnableEnum codeEnum : values) {
            if(codeEnum.getCode() == code) {
                result = codeEnum;
                break;
            }
        }
        return result;
    }

    public static List<DevEnableEnum> getResultCodes() {
        DevEnableEnum[] enums = values();
        List<DevEnableEnum> list = Arrays.asList(enums);
        return list;
    }

}
