package util;

import org.springframework.stereotype.Component;
/**
 * 用于切换本地访问，和手机端IP访问
 */
@Component
public class IP {
	//本地IP
	public static String ip="http://localhost:8080/bigflight/";
	//从别的地方IP访问
	//public static String ip= "http://192.168.1.49:8080/bigflight/";
}
