package org.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    private static final char[] DIGITS_LOWER = new char[]{'0', '2', 'a', 'b', '3', '4', '5', '6', 'c', '7', '8', '9', '1', 'd', 'e', 'f'};

    protected static MessageDigest messageDigest = null;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(Md5Util.class.getName() + "初始化失败, MessageDigest不支持Md5Util.");
            ex.printStackTrace();
        }
    }

    //通过MD5进行加密
    public static String getMd5String(String data) {
        //获取MD5的摘要
        return getMd5String(data.getBytes());
    }

    public static String getMd5String(byte[] data) {
        //使用指定的直接更新摘要
        messageDigest.update(data);
        //获取计算过后的数据
        byte[] digest = messageDigest.digest();
        //将密文转成32位，输出成字符串
        return new String(encodeHex(digest));
    }

    //字节数据装换
    private static char[] encodeHex(byte[] data) {
        //获取数据字节长度
        int n = data.length;
        //a << b 的意思就是a*2的b次方，>>就是除以
        char[] out = new char[n << 1];
        int i = 0;
        for (int v = 0; i < n; ++i) {
            out[v++] = DIGITS_LOWER[(240 & data[i]) >>> 4];
            out[v++] = DIGITS_LOWER[15 & data[i]];
        }
        return out;
    }

    public static void main(String[] args) {
        String data = "12312312334234234";
        String md5 = getMd5String(data);
        System.out.println(md5);
    }
}
