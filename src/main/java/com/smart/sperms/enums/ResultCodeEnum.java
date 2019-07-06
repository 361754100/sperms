package com.smart.sperms.enums;

/**
 * 结果集状态码
 */
public enum ResultCodeEnum {

    UNKNOW(-1, "未知异常"),
    SUCCESS(100, "成功"),
    FAILURE(-100, "异常");

    private int code;
    private String desc;
    private static ResultCodeEnum[] values = values();

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static ResultCodeEnum getResult(int code) {
        ResultCodeEnum result = UNKNOW;
        for(ResultCodeEnum codeEnum : values) {
            if(codeEnum.getCode() == code) {
                result = codeEnum;
                break;
            }
        }
        return result;
    }

}
