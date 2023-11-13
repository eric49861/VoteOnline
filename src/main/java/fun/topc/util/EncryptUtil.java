package fun.topc.util;


import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * 包名称：fun.topc.util
 * 类名称：EncryptUtil
 * 类描述：加密工具类
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 23:04
 */
public class EncryptUtil {

    public static String md5(String s) {
        String hash = DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
        return hash;
    }
}
