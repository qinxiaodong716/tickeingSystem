package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/*
 * 应用配置类(Spring配置)相当于xml的替代者
 */
@Configuration
@ComponentScan({"dao","service","util"})
@Import(JDBConfig.class)
public class AppConfig extends WebMvcConfigurationSupport{
	/*
	 * jsp解析器
	 */
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");  //位置[受保护的，不可以直接访问]
		resolver.setSuffix(".jsp");       //jsp文件的后缀，配置它以后跳转页面不需要写后缀，只写文件名就行了
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		super.addResourceHandlers(registry);
	}
}
