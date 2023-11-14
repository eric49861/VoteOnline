package fun.topc.controller;

import fun.topc.bean.Vote;
import fun.topc.dto.Result;
import fun.topc.dto.VoteDTO;
import fun.topc.service.IVoteService;
import fun.topc.util.EncryptUtil;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * 包名称：fun.topc.controller
 * 类名称：VoteController
 * 类描述：和用户投票相关的控制层，主要用于接收投票参与者的请求
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 20:09
 */

@CrossOrigin
@RestController
@RequestMapping("/vote")
public class VoteController {

    private IVoteService voteService;
    
    @Autowired
    public VoteController(IVoteService voteService) {
        this.voteService = voteService;
    }

    /**
     * @Title: addVote
     * @Description: 添加投票活动
     * @param voteDTO 投票活动的数据
     * @return: Result<String>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/14 17:09
     */
    @PostMapping("/add")
    public Result<String> addVote(@RequestBody VoteDTO voteDTO) {
        String link = EncryptUtil.md5(voteDTO.getTopic());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Vote v = new Vote(null, voteDTO.getUserId(), voteDTO.getTopic(), voteDTO.getStartDate(), voteDTO.getEndDate(), voteDTO.getOptions(), voteDTO.getDesc(), link, now, now);
        voteService.insertVote(v);
        return Result.success("创建新的投票活动成功");
    }

    /**
     * @Title: queryVote
     * @Description: 获取投票数据
     * @param userId 用户的id
     * @param status 用于标识投票活动的状态，0表示全部；1表示正在进行的投票活动；2表示已经结束的投票活动
     * @return: Result<List<Vote>>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/14 22:45
     */
    @GetMapping("/query/{userId}/{status}")
    public Result<List<Vote>> queryVote(@NotNull @PathVariable("userId") Integer userId, @NotNull @PathVariable("status") Integer status) {
        switch(status) {
            case 0:
                return Result.success("获取全部投票活动", voteService.queryAll(userId));
            case 1:
                return Result.success("获取正在进行的投票活动", voteService.queryVoting(userId));
            case 2:
                return Result.success("获取已经结束的投票活动", voteService.queryOver(userId));
            default:
                return Result.fail(HttpStatus.BAD_REQUEST.value(), "错误的请求");
        }
    }
}
