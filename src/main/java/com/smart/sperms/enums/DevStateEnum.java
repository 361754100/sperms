package com.smart.sperms.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 设备状态码
 * 0：在线、1：离线、2：停机、3：故障、4：报废、5：其它
 */
public enum DevStateEnum {

    UNKNOW(5, "未知异常"),
    ONLINE(0, "在线"),
    OFFLINE(1, "离线"),
    STOP(2, "停机"),
    ERROR(3, "故障"),
    SCRAPP(4, "报废");

    private int code;
    private String desc;
    private static DevStateEnum[] values = values();

    DevStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static DevStateEnum getResult(int code) {
        DevStateEnum result = UNKNOW;
        for(DevStateEnum codeEnum : values) {
            if(codeEnum.getCode() == code) {
                result = codeEnum;
                break;
            }
        }
        return result;
    }

    public static List<DevStateEnum> getResultCodes() {
        DevStateEnum[] enums = values();
        List<DevStateEnum> list = Arrays.asList(enums);
        return list;
    }

}
