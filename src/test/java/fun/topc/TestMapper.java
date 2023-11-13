package fun.topc;

import fun.topc.bean.User;
import fun.topc.config.MyBatisConfig;
import fun.topc.config.SpringConfig;
import fun.topc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 包名称：fun.topc
 * 类名称：TestMapper
 * 类描述：测试数据库的操作
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 21:38
 */
@SpringJUnitConfig({SpringConfig.class, MyBatisConfig.class})
public class TestMapper {

    private UserMapper userMapper;

    @Autowired
    public TestMapper(UserMapper mapper){
        this.userMapper = mapper;
    }

    @Test
    public void testInsertUser() {
        userMapper.insertUser("1585416826@qq.com", "123456");
    }

    @Test
    public void testSelectUser() {
        User user = userMapper.selectUserByEmailAndPassword("11111111@qq.com", "123456");
        assert user != null;
        System.out.println(user.getId());
    }
}
