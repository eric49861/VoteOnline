package fun.topc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fun.topc.config.SpringConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 包名称：fun.topc
 * 类名称：JsonTest
 * 类描述：测试操作数据库json类型和java对json类型的转化
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 20:18
 */
@SpringJUnitConfig(SpringConfig.class)
public class JsonTest {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JsonTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Test
    public void testSQLJson() throws JsonProcessingException {
        String s = new ObjectMapper().writeValueAsString(new Bean(1, "name"));
        System.out.println(s);
        String sql = """
                INSERT INTO json_test VALUES(NULL, ?)
                """;
        jdbcTemplate.update(sql, s);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Bean{
    public Integer id;
    public String name;
}