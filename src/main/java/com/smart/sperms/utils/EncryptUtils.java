package com.smart.sperms.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Descript 加密工具类
 * @Author fuyuanming
 * @Date 2018-05-07 10:03:39
 * @Version 1.0
 */
public class EncryptUtils {
    //盐值
//    private static final String SALT = "xiaoming";
    private static final String SALT = "smart";
    //加密算法
    private static final String ALGORITHM_NAME = "MD5";
    //加密次数
    private static final int COUNT = 2;

    /**
     * MD5密码加密（不加盐）
     * @param password 明文密码
     * @return 16进制密文密码
     */
    public static String encryptPasswordByPassword(String password) {
        String encryptPassword = new SimpleHash(ALGORITHM_NAME, password).toHex();
        return encryptPassword;
    }

    /**
     * MD5密码加密（密码加盐混合）
     * @param password 明文密码
     * @return 16进制密文密码
     */
    public static String saltEncryptPasswordByPassword(String password) {
        String encryptPassword = new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(SALT), COUNT).toHex();
        return encryptPassword;
    }

    /**
     * MD5密码加密（密码+账号加盐混合）
     * @param password 明文密码
     * @param username 账号
     * @return 16进制密文密码
     */
    public static String saltEncryptPasswordByPasswordAndUsername(String password, String username) {
        String encryptPassword = new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(username + SALT), COUNT).toHex();
        return encryptPassword;
    }

    /**
     * base64加密
     * @param password 明文密码
     * @return
     */
    public static String EncryptBase64(String password) {
        return Base64.decodeToString(password);
    }

}
