package fun.topc.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.Random;

public class EmailUtil {

    // 邮箱服务器的地址
    private static final String EMAIL_HOST = "smtp.163.com";
    private static final Integer CODE_LENGTH = 6;
    private static final String NUMS_OPTIONS = "0123456789";
    private static Email sender;
    // 邮箱验证码的过期时间
    public static final int TIME = 5;

    // 邮箱服务器的用户名和授权码
    private static final String GRANT_CODE = System.getenv("GRANT_CODE");
    private static final String USERNAME = System.getenv("EMAIL_ADDRESS");

    private static final Random random = new Random();

    static {
        sender = new SimpleEmail();
        sender.setHostName(EMAIL_HOST);
        sender.setSmtpPort(994);
        sender.setAuthenticator(new DefaultAuthenticator(USERNAME, GRANT_CODE));
        sender.setSSLOnConnect(true);
        try {
            sender.setFrom(USERNAME);
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title: sendEmailCode
     * @Description: 发送验证码的功能
     * @param code 验证码
     * @param to 目标邮箱
     * @return: void
     * @throws: EmailException
     * @author: Eric
     * @Date: 2023/11/12 16:36
     */
    
    public static void sendEmailCode(String code, String to) throws EmailException {
        sender.setSubject("验证码");
        sender.setMsg("您的登录验证码: <h3>" + code + "</h3>有效时间为 " + TIME + " 分钟，请勿传播给他人");
        sender.addTo(to);
        sender.send();
    }

    /**
     * @Title: sendText
     * @Description: 通用邮箱的信息发送
     * @param message
     * @param to
     * @param subject
     * @return: void
     * @throws: EmailException
     * @author: Eric
     * @Date: 2023/11/12 16:35
     */
    public static void sendText(String message, String to, String subject) throws EmailException {
        sender.setSubject(subject);
        sender.setMsg(message);
        sender.addTo(to);
        sender.send();
    }

    public static String randomCode() {
        StringBuffer code = new StringBuffer();
        random.setSeed(System.nanoTime());
        for(int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(NUMS_OPTIONS.length());
            code.append(NUMS_OPTIONS.charAt(index));
        }
        return code.toString();
    }
}
