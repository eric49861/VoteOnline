package fun.topc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 包名称：fun.topc.config
 * 类名称：WebConfig
 * 类描述：SpringMVC的配置类，用于替代SpringMVC的配置文件
 * 创建人：@author Eric
 * 创建时间：2023年11月11日 19:11
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "fun.topc")
public class WebConfig implements WebMvcConfigurer {

}
