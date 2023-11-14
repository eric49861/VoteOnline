package fun.topc.service.impl;

import fun.topc.bean.Vote;
import fun.topc.mapper.VoteMapper;
import fun.topc.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 包名称：fun.topc.service.impl
 * 类名称：IVoteService
 * 类描述：
 * 创建人：@author Eric
 * 创建时间：2023年11月14日 17:02
 */

@Service
public class VoteService implements IVoteService {

    private VoteMapper voteMapper;

    @Autowired
    public VoteService(VoteMapper mapper) {
        this.voteMapper = mapper;
    }

    @Override
    public void insertVote(Vote vote) {
        voteMapper.insertVote(vote);
    }

    @Override
    public List<Vote> queryVoting(Integer userId) {
        List<Vote> votes = voteMapper.queryVoting(userId, new Timestamp(System.currentTimeMillis()));
        return votes;
    }

    @Override
    public List<Vote> queryAll(Integer userId) {
        List<Vote> votes = voteMapper.queryAll(userId);
        return votes;
    }

    @Override
    public List<Vote> queryOver(Integer userId) {
        List<Vote> votes = voteMapper.queryOver(userId, new Timestamp(System.currentTimeMillis()));
        return votes;
    }
}
