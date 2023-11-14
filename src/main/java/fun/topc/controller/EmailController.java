package fun.topc.controller;

import fun.topc.dto.EmailDTO;
import fun.topc.dto.Result;
import fun.topc.service.IEmailService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 包名称：fun.topc.controller
 * 类名称：EmailController
 * 类描述：由于接收邮箱相关的请求
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 14:26
 */
@CrossOrigin
@RestController
@RequestMapping("/email")
public class EmailController {

    private IEmailService service;

    @Autowired
    public EmailController(IEmailService service) {
        this.service = service;
    }

    /**
     * @Title: code
     * @Description: 获取验证码的服务
     * @param emailDTO
     * @return: Result<String>
     * @throws: EmailException
     * @author: Eric
     * @Date: 2023/11/13 17:16
     */
    @PostMapping("/code")
    public Result<String> code(@RequestBody EmailDTO emailDTO) throws EmailException {
        service.sendCode(emailDTO.getEmail());
        return Result.success("验证码已发送到邮箱，请注意查收");
    }
}
