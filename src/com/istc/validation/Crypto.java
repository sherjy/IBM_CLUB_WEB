package com.istc.validation;

/**
 * Created by Morn Wu on 2017/2/23.
 * 加解密，可能暂时没什么用
 */
import java.security.*;

public class Crypto {
    public static String toSHA1(String decript){
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
