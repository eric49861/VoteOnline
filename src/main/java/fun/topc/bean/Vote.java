package fun.topc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 包名称：fun.topc.bean
 * 类名称：Vote
 * 类描述：表示一个投票
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 20:14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    private Integer id;
    private String topic;
    private Timestamp startDate;
    private Timestamp endDate;
    private String options;
    private String desc;
    // 该投票活动的链接
    private String link;

    private Timestamp createAt;
    private Timestamp updateAt;
}
