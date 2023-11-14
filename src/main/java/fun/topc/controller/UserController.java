package fun.topc.controller;

import fun.topc.dto.LoginRequestDTO;
import fun.topc.dto.LoginResponseDTO;
import fun.topc.dto.Result;
import fun.topc.dto.UserInfoDTO;
import fun.topc.exception.CodeNotEqualException;
import fun.topc.exception.LoginException;
import fun.topc.exception.SignupException;
import fun.topc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * 包名称：fun.topc.controller
 * 类名称：UserController
 * 类描述：用户相关功能的控制层，主要包含登录注册，验证码等接口
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 20:05
 */
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;


    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }
    /**
     * @Title: login
     * @Description: 登录
     * @param loginRequestDTO
     * @return: Result<String>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/12 15:09
     */
    @PostMapping("/login")
    public Result<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) throws CodeNotEqualException, ExecutionException, LoginException {
        String token = userService.doLogin(loginRequestDTO.getEmail(), loginRequestDTO.getPassword(), loginRequestDTO.getCode());
        return Result.success("登录成功", new LoginResponseDTO(token));
    }

    /**
     * @Title: signup
     * @Description: 注册
     * @param loginRequestDTO
     * @return: Result<String>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/12 15:09
     */
    @PostMapping("/signup")
    public Result<String> signup(@RequestBody LoginRequestDTO loginRequestDTO) throws CodeNotEqualException, ExecutionException, SignupException {
        userService.doSignup(loginRequestDTO.getEmail(), loginRequestDTO.getPassword(), loginRequestDTO.getCode());
        return Result.success("注册成功");
    }

    /**
     * @Title: detailInfo
     * @Description: 获取用户的详细信息
     * @param 
     * @return: Result<UserInfoDTO>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/14 0:37
     */
    //todo: 通过在拦截器中检测用户token获取用户的信息， 然后通过request对象传递用户信息，在数据库查询后返回
    @GetMapping("/info")
    public Result<UserInfoDTO> detailInfo() {
        return Result.success(null, new UserInfoDTO("1585416826@qq.com"));
    }
}
