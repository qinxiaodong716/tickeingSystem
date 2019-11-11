package config;

import java.nio.charset.StandardCharsets;

import javax.servlet.FilterRegistration;
/*
 * Tomcat启动的时候会监测是否有这个接口的类，若检测到有这个类，就回实例化它，并调用它的onStartup方法
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 1.构造Spring容器
			AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		// 2.Spring容器加载类
			ctx.register(AppConfig.class);
		// 3.Spring容器接管ServletContext应用上下文对象
			ctx.setServletContext(servletContext);
		// 4.添加Servlet(至少添加一个Servlet，SpringMVC框架实现的入口Servlet)
			ServletRegistration.Dynamic servlet= 
					servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
			servlet.addMapping("/");
			servlet.setLoadOnStartup(1);
		// 5.添加字符编码的过看不过滤器
			FilterRegistration.Dynamic encodingFilte = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
			encodingFilte.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
			encodingFilte.setInitParameter("forceEncoding", "true");
			encodingFilte.addMappingForUrlPatterns(null, false, "/*");
	}

}
