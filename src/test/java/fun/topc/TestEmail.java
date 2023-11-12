package fun.topc;

import fun.topc.config.SpringConfig;
import fun.topc.util.EmailUtil;
import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 包名称：fun.topc
 * 类名称：TestEmail
 * 类描述：测试邮箱的功能
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 15:37
 */
@SpringJUnitConfig(SpringConfig.class)
public class TestEmail {

    @Test
    public void testSend() throws EmailException {
        EmailUtil.sendEmailCode("101010", "1585416826@qq.com");
    }
}
