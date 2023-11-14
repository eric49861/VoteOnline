package fun.topc.service;

import fun.topc.bean.Vote;

import java.util.List;

/**
 * 包名称：fun.topc.service
 * 类名称：IVoteService
 * 类描述：投票管理相关的接口
 * 创建人：@author Eric
 * 创建时间：2023年11月14日 17:01
 */
public interface IVoteService {

    /**
     * @Title: insertVote
     * @Description: 插入新的投票活动
     * @param vote
     * @return: void
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/14 17:38
     */
    void insertVote(Vote vote);
    
    List<Vote> queryVoting(Integer userId);

    List<Vote> queryAll(Integer userId);

    List<Vote> queryOver(Integer userId);

}
