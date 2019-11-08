package config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/*
 * 数据库配置
 * (1).配置类要告诉你的配置信息的位置,@PropertySource
 * (2).利用IOC注入配置信息@value
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JDBCConfig {
	//--1.配置信息
	@Value("${jdbc.driverClass}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	//--2.数据源的Bean DataSource Bean
	@Bean(name="dataSource")
	public DataSource createDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	//--3.jdbcTemplate
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createjdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
