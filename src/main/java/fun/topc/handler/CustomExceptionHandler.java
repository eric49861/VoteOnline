package fun.topc.handler;

import fun.topc.dto.Result;
import org.apache.commons.mail.EmailException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 包名称：fun.topc.handler
 * 类名称：CustomExceptionHandler
 * 类描述：统一异常处理
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 17:42
 */
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = EmailException.class)
    public Result<String> emailExceptionHandler(EmailException e) {
        System.out.println(e.getMessage());
        return Result.fail(HttpStatus.BAD_REQUEST.value(), "验证码获取失败, 请稍后重试");
    }

    @ExceptionHandler(value = DataAccessException.class)
    public Result<String> dataAccessException(DataAccessException e) {
        System.out.println(e.getMessage());
        return Result.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "发生未知错误");
    }
}
