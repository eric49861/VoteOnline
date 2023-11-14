package fun.topc.service.impl;

import com.google.common.cache.LoadingCache;
import fun.topc.service.IEmailService;
import fun.topc.util.EmailUtil;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * 包名称：fun.topc.service
 * 类名称：EmailService
 * 类描述：邮箱服务
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 16:45
 */
@Service
public class EmailService implements IEmailService {

    private LoadingCache<String, String> loadingCache;

    @Autowired
    public EmailService(LoadingCache<String, String> loadingCache) {
        this.loadingCache = loadingCache;
    }

    /**
     * @Title: sendCode
     * @Description: 发送验证码的逻辑
     * @param to 目标邮箱
     * @return: void
     * @throws: EmailException
     * @author: Eric
     * @Date: 2023/11/12 16:49
     */
    @Override
    public void sendCode(String to) throws EmailException {
        // 发送验证码
        String code = EmailUtil.randomCode();
        // 将验证码放入本地缓存
        loadingCache.put(to, code);
        // 发送邮件
        EmailUtil.sendEmailCode(code, to);
    }

    /**
     * @Title: compareCode
     * @Description: 比较验证码是否正确
     * @param code
     * @return: boolean
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/12 18:01
     */
    @Override
    public boolean compareCode(String email, String code) throws ExecutionException {
        String s = loadingCache.get(email);
        return code.equals(s);
    }

}
