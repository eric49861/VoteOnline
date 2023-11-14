package fun.topc.service;

import fun.topc.exception.CodeNotEqualException;
import org.apache.commons.mail.EmailException;

import java.util.concurrent.ExecutionException;

/**
 * 包名称：fun.topc.service
 * 类名称：IEmailService
 * 类描述：邮箱服务接口
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 16:45
 */
public interface IEmailService {

    /**
     * @Title: sendCode
     * @Description: 发送验证法
     * @param to 目标邮箱
     * @return: void
     * @throws: EmailException
     * @author: Eric
     * @Date: 2023/11/12 17:57
     */
    void sendCode(String to) throws EmailException;

    /**
     * @Title: compareCode
     * @Description: 比较验证码是否正确
     * @param code
     * @return: boolean
     * @throws: CodeNotEqualException
     * @author: Eric
     * @Date: 2023/11/12 18:00
     */
    boolean compareCode(String email, String code) throws CodeNotEqualException, ExecutionException;
}
