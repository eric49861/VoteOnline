package fun.topc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fun.topc.constant.Sex;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.dto
 * 类名称：ParticipantDTO
 * 类描述：
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 22:03
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParticipantDTO {
    @NotNull
    @JsonProperty("age")
    private Integer age;
    @NotNull
    @JsonProperty("sex")
    private Sex sex;
    @NotNull
    @JsonProperty("occupation")
    private String occupation;
}
