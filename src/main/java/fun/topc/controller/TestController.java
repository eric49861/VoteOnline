package fun.topc.controller;

import fun.topc.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：fun.topc.controller
 * 类名称：TestController
 * 类描述：用于测试框架是否搭建完成，能否正常接收客户端的请求
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 19:45
 */
@RestController
public class TestController {

    @GetMapping("/ping")
    public Result<String> testPing() {
        return Result.success("Hello World");
    }
}
