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

    // 配置jdbc
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.setQueryTimeout(3000);
        return jdbcTemplate;
    }

    // 配置数据库的数据源
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
