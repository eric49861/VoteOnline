package fun.topc.constant;

import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.util.Calendar;

/**
 * 包名称：fun.topc.constant
 * 类名称：Token
 * 类描述：存放和token相关的常量
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 17:33
 */

public class Token {
    public static final String SECRET = "vote-online";
    public static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    public static final Long EXPIRE_AFTER = 30 * 60 * 60 * 1000L; // 30min
}
