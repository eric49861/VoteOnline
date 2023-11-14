package fun.topc.service.impl;

import fun.topc.bean.User;
import fun.topc.dto.Result;
import fun.topc.exception.CodeNotEqualException;
import fun.topc.exception.LoginException;
import fun.topc.exception.SignupException;
import fun.topc.mapper.UserMapper;
import fun.topc.service.IEmailService;
import fun.topc.service.IUserService;
import fun.topc.util.EncryptUtil;
import fun.topc.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * 包名称：fun.topc.service
 * 类名称：UserService
 * 类描述：用户相关的服务接口
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 23:29
 */
@Service
public class UserService implements IUserService {

    private UserMapper userMapper;

    private IEmailService emailService;


    @Autowired
    public UserService(UserMapper userMapper, IEmailService emailService) {
        this.userMapper = userMapper;
        this.emailService = emailService;
    }

    @Override
    public String doLogin(String email, String password, String code) throws CodeNotEqualException, ExecutionException, LoginException {
        // 查询用户信息
        User user = userMapper.selectUserByEmailAndPassword(email, EncryptUtil.md5(password));
        if (user == null) {
            throw new LoginException("用户不存在");
        }
        // 对比验证码是否正确
        boolean equal = emailService.compareCode(email, code);
        if (!equal) {
            return null;
        }
        // 根据用户信息生成token
        String token = JWTUtil.generateToken(user);
        return token;
    }

    /**
     * @Title: doSignup
     * @Description:
     * @param email
     * @param password
     * @return: void
     * @throws:
     * @author: Eric
     * @Date: 2023/11/14 16:27
     */
    @Override
    public void doSignup(String email, String password, String code) throws SignupException, CodeNotEqualException, ExecutionException {
        // 查询邮箱是否已经注册
        int count = userMapper.selectCountByEmail(email);
        if(count == 1) {
            throw new SignupException("邮箱已存在");
        }
        // 对比用户的验证码是否正确
        boolean equal = emailService.compareCode(email, code);
        if(!equal) {
            throw new CodeNotEqualException("验证码不正确");
        }
        // 将用户信息插入数据库
        userMapper.insertUser(email, EncryptUtil.md5(password));
    }

    /**
     * @Title: emailExists
     * @Description: 查询用户邮箱是否存在的服务
     * @param email
     * @return: boolean
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/14 16:32
     */
    @Override
    public boolean emailExists(String email) {
        return userMapper.selectCountByEmail(email) == 1;
    }

    @Override
    public User detailInfo() {
        return null;
    }
}
