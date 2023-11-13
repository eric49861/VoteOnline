package fun.topc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import fun.topc.bean.User;
import fun.topc.constant.Token;

import java.util.Date;

/**
 * 包名称：fun.topc.util
 * 类名称：JWTUtil
 * 类描述：jwt工具类，用于生成和解析token
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 17:23
 */
public class JWTUtil {

    /**
     * @Title: generateToken
     * @Description: 根据用户信息生成token
     * @param user
     * @return: String
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/13 17:41
     */
    public static String generateToken(User user) {
        String token = JWT.create()
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + Token.EXPIRE_AFTER))
                .sign(Token.ALGORITHM);
        return token;
    }

    /**
     * @Title: parseToken
     * @Description: 根据token解析
     * @param token token
     * @return: boolean
     * @throws:
     * @author: Eric
     * @Date: 2023/11/13 17:43
     */
    public static boolean parseToken(String token) {
        JWTVerifier build = JWT.require(Token.ALGORITHM).build();
        DecodedJWT verify = null;
        try {
            verify = build.verify(token);
        }catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
