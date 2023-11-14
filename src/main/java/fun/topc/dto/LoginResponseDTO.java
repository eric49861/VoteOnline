package fun.topc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.dto
 * 类名称：LoginResponseDTO
 * 类描述：登录响应的数据格式
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 23:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    @NotNull
    @JsonProperty("token")
    private String token;
}
