package fun.topc.service;

import fun.topc.bean.User;
import fun.topc.exception.CodeNotEqualException;
import fun.topc.exception.LoginException;
import fun.topc.exception.SignupException;

import java.util.concurrent.ExecutionException;

/**
 * 包名称：fun.topc.service.impl
 * 类名称：IUserService
 * 类描述：用户服务接口
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 18:10
 */
public interface IUserService {

    /**
     * @Title: doLogin
     * @Description:
     * @param email
     * @param password
     * @return: String
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/13 23:36
     */
    String doLogin(String email, String password, String code) throws CodeNotEqualException, ExecutionException, LoginException;

    /**
     * @Title: doSignup
     * @Description: 
     * @param email
     * @param password
     * @return: void
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/13 23:36
     */
    void doSignup(String email, String password, String code) throws SignupException, CodeNotEqualException, ExecutionException;
    
    /**
     * @Title: detailInfo
     * @Description: 详情信息
     * @param
     * @return: User
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/14 0:41
     */
    User detailInfo();

    /**
     * @Title: emailExists
     * @Description: 查询用户邮箱是否存在
     * @param email
     * @return: boolean
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/14 16:31
     */
    boolean emailExists(String email);
}
