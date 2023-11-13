package fun.topc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 包名称：fun.topc.config
 * 类名称：SpringConfig
 * 类描述：用于声明容器中的JavaBean，整合其他框架
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 19:02
 */

@Configuration
public class SpringConfig {

    /**
     * @Title: jdbcTemplate
     * @Description: 配置jdbc的Bean，但是该类并不会真正使用，可以用来测试一些数据库的表操作
     * @param dataSource
     * @return: JdbcTemplate
     * @throws: 
     * @author: Eric
     * @Date: 2023/11/13 20:27
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.setQueryTimeout(3000);
        return jdbcTemplate;
    }

    @Bean
    public LoadingCache<String, String> loadingCache() {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                        .expireAfterWrite(5, TimeUnit.MINUTES)
                .maximumSize(1000)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return "";
                    }
                });
        return loadingCache;
    }
}
