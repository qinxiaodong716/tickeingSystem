package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/*
 * 应用配置类(Spring配置)相当于xml的替代者
 */
@Configuration
@ComponentScan({"dao","service","util"})
@Import(JDBConfig.class)
@EnableAspectJAutoProxy //启动自定义切面标注的AOP功能
public class TestConfig {
	
}
