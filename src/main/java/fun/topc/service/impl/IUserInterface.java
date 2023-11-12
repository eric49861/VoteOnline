package fun.topc.service.impl;

import fun.topc.dto.UserDTO;

/**
 * 包名称：fun.topc.service.impl
 * 类名称：IUserInterface
 * 类描述：用户服务接口
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 18:10
 */
public interface IUserInterface {

    void doLogin(String email, String password, String code);

    void doSignup(String email, String password, String code);
}
