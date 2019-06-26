package com.example.demo.digest;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.*;

/**
 * @Description: 摘要加密与解密
 * @Author: Eric Lee
 * @Date: 2019/3/8
 */
public class DigestMD5 {
    private String getDigest(Map<String, String> params) throws Exception {
        String secret = "密钥";
        Set<String> keySet = params.keySet();

        //使用treeset排序
        TreeSet<String> sortSet = new TreeSet<String>();
        sortSet.addAll(keySet);
        String keyValueStr = "";

        Iterator<String> it = sortSet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = params.get(key);
            keyValueStr += key + value;
        }

        keyValueStr += secret;
        MessageDigest md = MessageDigest.getInstance("MD5");
        BASE64Encoder base64encode = new BASE64Encoder();
        return base64encode.encode(md.digest(keyValueStr.getBytes("utf-8")));
    }

    private boolean validate(Map<String, String> params, String digest) throws Exception {

        String srcret = "密钥";
        Set<String> keySet = params.keySet();
        TreeSet<String> sortSet = new TreeSet<String>();
        sortSet.addAll(keySet);
        String keyValueStr = "";
        Iterator<String> it = sortSet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = params.get(key);
            keyValueStr += key + value;
        }

        keyValueStr += srcret;
        MessageDigest md = MessageDigest.getInstance("MD5");
        BASE64Encoder base64encode = new BASE64Encoder();
        String base64Str = base64encode.encode(md.digest(keyValueStr.getBytes("utf-8")));
        System.out.println("加密串：" + base64Str);
        if (base64Str.equals(digest)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {

        Map map = new HashMap();
        map.put("name", "Mr Lee");
        map.put("pwd", "123456");
        DigestMD5 digestMD5 = new DigestMD5();
        System.out.println("加密串：" + digestMD5.getDigest(map));

        System.out.println(digestMD5.validate(map, digestMD5.getDigest(map)));

    }

}
