package com.smart.sperms.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 统计方式
 * 1：按天，2：按月，9：其它
 */
public enum StatTypeEnum {

    UNKNOW(9, "未知异常"),
    BY_DAY(1, "按天"),
    BY_MONTH(2, "按月");

    private int type;
    private String desc;
    private static StatTypeEnum[] values = values();

    StatTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }

    public static StatTypeEnum getType(int type) {
        StatTypeEnum result = UNKNOW;
        for(StatTypeEnum typeEnum : values) {
            if(typeEnum.getType() == type) {
                result = typeEnum;
                break;
            }
        }
        return result;
    }

    public static List<StatTypeEnum> getStatTypes() {
        StatTypeEnum[] enums = values();
        List<StatTypeEnum> list = Arrays.asList(enums);
        return list;
    }

}
