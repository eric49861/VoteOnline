package fun.topc.bean;

import fun.topc.constant.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.bean
 * 类名称：Participant
 * 类描述：代表投票的参与者(可能用不到)
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 21:14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    private Integer id;
    private String ip;
    private String location;
    private Integer age;
    private Sex sex;
    private String occupation;
}
