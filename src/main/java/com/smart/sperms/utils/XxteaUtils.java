package com.smart.sperms.utils;

import org.xxtea.XXTEA;

/**
 * XXTEA 加密工具类
 */
public class XxteaUtils {

    /**
     * 数据加密后生成十六进制字符串
     * @param data
     * @param key
     * @return
     */
    public static String encryptToHexString(String data, String key) {
        byte[] dataBytes = XXTEA.encrypt(data, key);
        String encryptData = StringUtils.bytesToHexString(dataBytes);
        return encryptData;
    }

    /**
     * 十六进制字符串数据解密
     * @param data
     * @param key
     * @return
     */
    public static String decryptFromHexString(String data, String key) {
        byte[] dataBytes = StringUtils.hexStringToBytes(data);
        String decryptData = XXTEA.decryptToString(dataBytes, key);
        return decryptData;
    }

}
