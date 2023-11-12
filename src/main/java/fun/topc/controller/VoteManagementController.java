package fun.topc.controller;

import fun.topc.dto.Result;
import fun.topc.dto.VoteDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 包名称：fun.topc.controller
 * 类名称：VoteManagementController
 * 类描述：和投票管理相关的接口，主要和投票发布者对投票主题的增删改查
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 20:06
 */
@RestController("/votemanagement")
public class VoteManagementController {

    /**
     * @Title: createVote
     * @Description: 创建投票活动
     * @param voteDTO
     * @return: Result<String>
     * @throws:
     * @author: Eric
     * @Date: 2023/11/11 23:53
     */

    @PostMapping("/add")
    public Result<String> createVote(@RequestBody VoteDTO voteDTO) {
        System.out.println("voteDTO = " + voteDTO);
        return Result.success("创建一个投票活动");
    }

    /**
     * @Title: deleteVote
     * @Description: 删除投票活动
     * @param id
     * @return: Result<String>
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/11 23:53
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteVote(@PathVariable("id") Integer id) {
        return Result.success("删除投票记录");
    }

    /**
     * @Title: queryVote
     * @Description:
     * @param status
     * @return: Result<String>
     * @throws:
     * @author: Eric
     * @Date: 2023/11/11 23:54
     */
    @GetMapping("/{status}")
    public Result<String> queryVote(@PathVariable("status") Integer status) {
        return Result.success("查询投票记录");
    }
}
