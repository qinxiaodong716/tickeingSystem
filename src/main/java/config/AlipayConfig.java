package config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016101600702119";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4RmX7KcmxntjXugv+2ATwKF6E3ntDVPVvhODmiev0tjjwzN51jNlsviwaClvNL8xwrHWSKkcnGuCqVUKUgdaaxjrta+SCMrCI77xv7ci59+0BKgiFm0KzR0X1Kmq27df8/q9Xlyi5L8X/sRA+G62GJvTensEvebvUh19bbz1qX6m2eMBlbhOBMb2c82DwiBp6iqLTyK30I9tqB+0ULAZVWqlxqyGw17R77J4+YD0OgO4W1pwhGkBxsbuBg4aJlNO7OpPyHJuVtdy88kl+6eFApM1mXYtN5knrsBfOdiuBFoj+4m/LxNEbma7yrozdXAandCYtUEf71NgnrGbqqqXbAgMBAAECggEBAKdM4tHBAqkMOnrBIprgrLsNK6MeCnL680moLjegCGVH+zJEDcRTeCLOFWQe+3Gyb73sFWH6mFbchBShC62go6IpTt63EeNS+guY/E/yZkbQ3JAuBUany0rQ7qbDN9eU4H+FCtRPHF3lDbIyoziAEG63d6GWKHZd4zX1IZH10KB9ZWplPR40Pz0n1S/9WHJqE34QPRmP2O6Ey1uHm0obvd9FeDCfqQc560voKvyAG2jBYglSQOuo5xNll0LhbJDF8+R/Hyk/XeYGz0Ayyu0/U/b3bF5LaN3yMBCEfSThcU7Q4T+5rkpZOg7sIrRPpx2hKOsUP8Djld+mLteaaF4/csECgYEA72ab2pypNd0gCh3hEEuA8f6RKWRkt4ZZeruV4VtIal915h3Ab9K5zOt3yDsSO75Jj/UCqEauIWfashM5U82Y3TRKrttvx3Ms2hqrU8mFE1ZIIkquZvSccP+5Ao6tc5ulEa8b2bp/123U+DZ1AmmkNO/dutV6QvgYzE8e7R52O4kCgYEAxQ1M0R4KAntNbWIdACdzzBUuCZ0LdSdcBL5nWKBwD5CddsSx8i+/r4mgVKRPFvolLo1E7Vbt8T25u9zpzo/qY32l28sleZqW9lDUjQli8MGK1CWUtf3smC7XVyhrOUfS6MZtOQeVDVUBrqCcEi60VPFojzijENvBWn0Bv0oHSUMCgYAohoAfk6F5QsNnswMkVQOw81zzWtFJ1+5RvmtyyJcLmrlEiQjIZS2aqMmQFZ/SiTW+rsUSY1Saxw/YUTTFIOqdl3qE+xSC+NZA3X7fIh/q1BJF68p2FzZcUo2pByoJhfF9et0GEHIPr8H7eox4KhXn+Cras8SMjZ71Bve/QAbXsQKBgFw0Tv+C+NgUbjSCtmM+ErcqKfKho5zcH/iwR5d26zi9SJEslL9ojF9NHNK+V6u+vOs9e0U7afd6FJDNXDIlsV2Ai71/Hzf5mC4FwI+GFt/lEFsYgq9t8+l58ZV8+j9BVnVJdA49eAdXAYR+7sirRgKBO5XYwKTAz4bR+6FQuHwVAoGBANFRe2rnQlU8c486qn7aHXTAy3dSS1X61WP4r5n5vx7j6PvZhUtDU0st1fVnyVx1f+0KKJT1X8wPCb0ZCOzNWsflYRCttalGHFUE7wznsYNmr416EJo2nKDBcJNLICXyUjC6hQPOy8PM31BBE5i3SqLf5jdqOmqo+vw9V5tn9Mfy";
    
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuEZl+ynJsZ7Y17oL/tgE8ChehN57Q1T1b4Tg5onr9LY48MzedYzZbL4sGgpbzS/McKx1kipHJxrgqlVClIHWmsY67WvkgjKwiO+8b+3IufftASoIhZtCs0dF9Spqtu3X/P6vV5couS/F/7EQPhuthib03p7BL3m71IdfW289al+ptnjAZW4TgTG9nPNg8Igaeoqi08it9CPbagftFCwGVVqpcashsNe0e+yePmA9DoDuFtacIRpAcbG7gYOGiZTTuzqT8hyblbXcvPJJfunhQKTNZl2LTeZJ67AXznYrgRaI/uJvy8TRG5mu8q6M3VwGp3QmLVBH+9TYJ6xm6qql2wIDAQAB";
    
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "https://openapi.alipaydev.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    /*public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}

