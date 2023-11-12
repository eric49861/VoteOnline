package fun.topc.controller;

import fun.topc.dto.LoginDTO;
import fun.topc.dto.Result;
import fun.topc.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 包名称：fun.topc.controller
 * 类名称：UserController
 * 类描述：用户相关功能的控制层，主要包含登录注册，验证码等接口
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 20:05
 */
@CrossOrigin
@RestController("/user")
public class UserController {

    /**
     * @Title: login
     * @Description: 登录逻辑
     * @param loginDTO
     * @return: Result<String>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/12 15:09
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO) {
        return Result.success("登录成功");
    }

    /**
     * @Title: signup
     * @Description: 注册逻辑
     * @param loginDTO
     * @return: Result<String>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/12 15:09
     */
    @PostMapping("/signup")
    public Result<String> signup(@RequestBody LoginDTO loginDTO) {
        return Result.success("注册成功");
    }

}
