package edu.ntvu.springmvcdemo2.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @author alin
 * @Package edu.ntvu.springmvcdemo2.util
 * @date 2021/3/29 19:31
 * @description 加密工具类
 */
public class EncryptTools {

    /**
     * md5 生成摘要密文
     * @param data 明文
     * @param salt 盐
     * @return 密文
     */
    public static String md5(String data, String salt) {
        return DigestUtils.md5Hex(data + salt);
    }

    /**
     * md5 加密
     * @param data 明文
     * @return 密文字符串
     */
    public static String md5(String data) {
        return DigestUtils.md5Hex(data);
    }

    /**
     * 生成一个随机字符串
     * @return 一个 24 位长的随机字符串
     */
    public static String getRandomStr() {
        byte[] arr = new byte[12];
        SecureRandom random = new SecureRandom();
        random.nextBytes(arr);

        return byteToHexString(arr);
    }

    /**
     * 将 byte[] 数组转换为 16 进制字符串
     * @param bytes byte[] 数组
     * @return 16 进制字符串
     */
    public static String byteToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);

            if (hex.length() == 1)
                hex = '0' + hex;

            hexString.append(hex.toUpperCase());
        }

        return hexString.toString();
    }

}
