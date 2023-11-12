package fun.topc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 包名称：fun.topc.dto
 * 类名称：Result
 * 类描述：统一响应的格式
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 19:47
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(HttpStatus.OK.value(), message, data);
    }

    public static <T> Result<T> success(String message) {
        return new Result<T>(HttpStatus.OK.value(), message, null);
    }

    public static <T> Result<T> success(Integer code, String message, T data) {
        return new Result<T>(code, message, data);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<T>(code, message, null);
    }
}
