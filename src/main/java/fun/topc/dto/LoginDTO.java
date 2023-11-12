package fun.topc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.dto
 * 类名称：LoginDTO
 * 类描述：
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 15:07
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @Email(message = "邮箱格式不正确")
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String code;
}
