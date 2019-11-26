package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 日期工作类
 */
public class DateUtil {
	/* 
	 * 根据某种格式吧字符串转化为日期
	 * @param dateFormat 日期格式
	 * @param dataStr    日期字符串
	 * @return 日期
	 */
	public static Date ToDate(String dateFormat,String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 根据某种日期格式把日期转换为字符串
	 * 
	 * @param dateFormat 日期格式
	 * @param dataStr    日期字符串
	 * @return 日期字符串
	 */
	public static String DateToString(String dateFormat,Date dateStr) {
		return new SimpleDateFormat(dateFormat).format(dateStr);
	}
}
