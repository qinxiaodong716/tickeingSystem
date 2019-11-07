package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/*
 * 
 */
@Aspect
@Component
public class PagerAspect{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//--自定义切点
	@Pointcut("execution(* service..*(..))")
	public void selfPointcut() {}
	
	//--自定义通知
	@Around("selfPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint jp) {
		Object o = null;
		//--1.根据jp对象获取Menthod对象
		MethodSignature signature = (MethodSignature)jp.getSignature();
		Method m = signature.getMethod();
		//--2.Method对象获取是否含有@MiniPager标注
		MiniPager miniPager = (MiniPager)m.getAnnotation(MiniPager.class);
		//--3.若没有@MiniPager标注，则执行原始业务方法
		if(miniPager==null) {
			try {
				o = jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return o;
		}
		//若加有@MiniPager标注,则加入分页代码
		//--获取某实体类对应的总条目数
		String tableName = miniPager.tableName();
		int totalItems = jdbcTemplate.queryForObject("select count(*) from "+tableName, 
				Integer.class);
		//--根据也大小计算总的页数
		int pageSize = (Integer)jp.getArgs()[1];
		int pageNo = (Integer)jp.getArgs()[0];
		int totalPagers = (totalItems + pageSize -1)/pageSize;
		if(pageNo>totalPagers) {
			pageNo = totalPagers;
		}
		//--
		Pager pager = new Pager();
		try {
			List data = (List)jp.proceed(new Object[]{pageNo,pageSize});
			pager.setData(data);
			pager.setTotal(totalPagers);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pager;
	}
}
