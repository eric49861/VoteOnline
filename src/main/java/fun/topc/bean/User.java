package fun.topc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.bean
 * 类名称：User
 * 类描述：和数据库用户表映射的bean
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 20:10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String password;
}
