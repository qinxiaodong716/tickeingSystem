package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/*
 * 应用配置类(Spring配置)相当于xml的替代者
 */
@Configuration
@ComponentScan({"dao","service","util","controller"})
@Import(JDBCConfig.class)
public class TestConfig {
	
}
