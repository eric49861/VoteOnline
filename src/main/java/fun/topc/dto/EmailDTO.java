package fun.topc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.dto
 * 类名称：EmailDTO
 * 类描述：
 * 创建人：@author Eric
 * 创建时间：2023年11月12日 14:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    @Email
    @NotNull
    @JsonProperty("email")
    private String email;
}
