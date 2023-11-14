package fun.topc.config;

import com.alibaba.druid.pool.DruidDataSource;

import fun.topc.mapper.UserMapper;
import fun.topc.mapper.VoteMapper;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 包名称：fun.topc.config
 * 类名称：MyBatisConfig
 * 类描述：mybatis的配置类，使用Spring整合MyBatis
 * 创建人：@author Eric
 * 创建时间：2023年11月13日 20:21
 */
@Configuration
public class MyBatisConfig {
    /**
     * @Title: dataSource
     * @Description: 配置数据库连接的数据源，这里使用druid作为连接池
     * @param
     * @return: DataSource
     * @throws:
     * @author: Eric
     * @Date: 2023/11/13 20:27
     */
    @Bean
    public DataSource dataSource() {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }

    /**
     * @Title: sqlSessionFactory
     * @Description: 配置SqlSessionFactory
     * @param dataSource
     * @return: SqlSessionFactory
     * @throws: Exception
     * @author: Eric
     * @Date: 2023/11/13 21:28
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 配置mybatis
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // 暂时使用标准输出作为日志输出
        configuration.setLogImpl(StdOutImpl.class);
        // 开启二级缓存
        configuration.setCacheEnabled(true);
        // 启用驼峰命名规则
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(UserMapper.class);
        // 设置配置
        factoryBean.setConfiguration(configuration);
        // 设置开发环境
        factoryBean.setEnvironment("development");
        // 设置数据源
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    /**
     * @Title: userMapper
     * @Description: 配置用户的数据接口
     * @param factory
     * @return: UserMapper
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/13 21:27
     */
    @Bean
    public UserMapper userMapper(SqlSessionFactory factory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factory);
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper;
    }

    @Bean
    public VoteMapper voteMapper(SqlSessionFactory factory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factory);
        VoteMapper mapper = sqlSessionTemplate.getMapper(VoteMapper.class);
        return mapper;
    }
}
