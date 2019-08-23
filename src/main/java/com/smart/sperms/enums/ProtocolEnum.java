package com.smart.sperms.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 协议码
 */
public enum ProtocolEnum {

    CODE_101(101, "Android端发送设备信息"),
    CODE_102(102, "服务端响应101"),
    CODE_103(103, "Android端发送压接信息"),
    CODE_104(104, "服务端响应103"),
    CODE_105(105, "Android端发送gps信息"),
    CODE_106(106, "服务端响应105"),
    CODE_107(107, "服务端下发控制机器是否工作"),
    CODE_108(108, "Android端响应107"),
    CODE_109(109, "服务端下发配置modbux起始地址"),
    CODE_110(110, "Android端响应109"),
    CODE_111(111, "服务端下发拍照指令"),
    CODE_112(112, "Android端响应111"),
    CODE_113(113, "服务端下发更新密钥"),
    CODE_114(114, "Android端响应113"),
    UNKNOW(-1, "未知异常");

    private int code;
    private String desc;
    private static ProtocolEnum[] values = values();

    ProtocolEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static ProtocolEnum getProtocol(int code) {
        ProtocolEnum result = UNKNOW;
        for(ProtocolEnum codeEnum : values) {
            if(codeEnum.getCode() == code) {
                result = codeEnum;
                break;
            }
        }
        return result;
    }

    public static List<ProtocolEnum> getProtocolCodes() {
        ProtocolEnum[] enums = values();
        List<ProtocolEnum> list = Arrays.asList(enums);
        return list;
    }

}
