package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD})                 //METHOD 可以放到方法上，
@Retention(RetentionPolicy.RUNTIME)
public @interface MiniPager {
	public String tableName();
}
