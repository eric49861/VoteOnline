package fun.topc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 包名称：fun.topc.dto
 * 类名称：VoteDTO
 * 类描述：用于前后端通信的数据格式
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 21:32
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteDTO {
    @JsonProperty("userId")
    private Integer userId;
    @NotNull
    @JsonProperty("topic")
    private String topic;
    @NotNull
    @JsonProperty("startDate")
    private Timestamp startDate;
    @NotNull
    @JsonProperty("endDate")
    private Timestamp endDate;
    @NotNull
    @JsonProperty("options")
    private String options;
    @NotNull
    @JsonProperty("desc")
    private String desc;
}
