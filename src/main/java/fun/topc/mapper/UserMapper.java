package fun.topc.mapper;

import fun.topc.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 包名称：fun.topc.mapper
 * 类名称：UserMapper
 * 类描述：用户表的映射接口，用于实现和用户查询相关的SQL操作
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 20:45
 */
public interface UserMapper {

    @Select("SELECT * FROM user WHERE email = #{email} AND password = #{password}")
    User selectUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Insert("INSERT INTO user VALUES(NULL, #{email}, #{password})")
    void insertUser(@Param("email") String email, @Param("password") String password);

    @Select("SELECT COUNT(*) FROM user WHERE email = #{email}")
    int selectCountByEmail(@Param("email") String email);
}
