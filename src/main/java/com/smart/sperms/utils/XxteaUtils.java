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
        String encryptData = bytesToHexString(dataBytes);
        return encryptData;
    }

    /**
     * 十六进制字符串数据解密
     * @param data
     * @param key
     * @return
     */
    public static String decryptFromHexString(String data, String key) {
        byte[] dataBytes = hexStringToBytes(data);
        String decryptData = XXTEA.decryptToString(dataBytes, key);
        return decryptData;
    }

    /**
     * Convert  byte[] to hex string
     * @param src is bytes
     * @return hexString
     */
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * Convert hex string to byte[]
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
