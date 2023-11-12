package fun.topc.exception;

import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.exception
 * 类名称：CodeNotEqualException
 * 类描述：验证码不正确的异常
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 17:58
 */

@NoArgsConstructor
public class CodeNotEqualException extends Exception{

    public CodeNotEqualException(String message) {
        super(message);
    }
}
