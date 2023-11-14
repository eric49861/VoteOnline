package fun.topc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.dto
 * 类名称：UserInfoDTO
 * 类描述：用户详细信息
 * 创建人：@author Eric
 * 创建时间：2023年11月14日 00:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    @JsonProperty("email")
    private String email;
}
