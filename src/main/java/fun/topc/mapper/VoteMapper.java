package fun.topc.mapper;

import fun.topc.bean.Vote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

/**
 * 包名称：fun.topc.mapper
 * 类名称：VoteMapper
 * 类描述：投票活动的映射接口
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 23:01
 */
public interface VoteMapper {

    @Insert("INSERT INTO vote VALUES (NULL, #{vote.userId}, #{vote.topic}, #{vote.startAt}, #{vote.endAt}, #{vote.options}, #{vote.desc}, #{vote.link}, #{vote.createAt}, #{vote.updateAt})")
    void insertVote(Vote vote);

    @Select("SELECT * FROM vote WHERE user_id = #{userId} AND (#{now} BETWEEN startAt AND endAt)")
    List<Vote> queryVoting(Integer userId, Timestamp now);

    @Select("SELECT * FROM vote WHERE user_id = #{userId} AND endAt <= #{now}")
    List<Vote> queryOver(Integer userId, Timestamp now);

    @Select("SELECT * FROM vote WHERE user_id = #{userId}")
    List<Vote> queryAll(Integer userId);

}
