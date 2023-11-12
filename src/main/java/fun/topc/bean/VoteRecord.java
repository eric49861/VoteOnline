package fun.topc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名称：fun.topc.bean
 * 类名称：VoteRecord
 * 类描述：表示投票的一次记录
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 21:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteRecord {
    private Integer id;
    // 投票主题的id
    private Integer vote_id;
    // 参与者的id
    private Integer participant_id;
    // 参与者投票的选项
    private Integer result;
}
