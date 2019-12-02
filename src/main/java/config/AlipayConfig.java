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
	public static String app_id = "2016101600702119";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCWgfGwjyAOzQZZUz9TcxgEeFZLQ1bFBi8MXaMeL5CsNU0LRrHJaEozxq7PdDT7/MVTjRbjt5hT1YVvL2uHHs7/4gE5hT8hvSc5Y5iWd0sOan1Bnof5vbX/Sr9SQJW10v1cukDqP7TSCxTNDeVqAvI/g+veQEz0Y6eQQ0tArOgJlvBvfxFqmY5HWh04yi8SN2ii6Ql9gbKO6zwR/x8ZXq14a4gWPog4ZjYsoFShfpzCJS6SOy463+BWGctX7uj9u50nEYxfxk758LHoFQaYvuPZM5DvqpHcouXJEKqNcGqHbtsSAlBVi1b0iu1hy70N7lJHwjkpYVzWMpiwtUr1eRiHAgMBAAECggEAPcwbDbCmrA0Yx0J8JOqD+Qnj/MEodntkhAJKgJFtKJg2CyQ6yYTNutagXkPLoY+XAghTVqrCm+F3CUECOJe4zK3ibNi+JD9DRLgVJerTYZbt2SybjjqL6MerKL2l+uMn7pP3JXeE6h1srAlBojaVeujSxw3Fyy7D1WMcGfEk0RKMZ3nefEOmYglfebSGn6CApflXYM8mE9zxg+4wTaD7W/3r4J5KETnSqsgGukU//aJMF7jSzJYziMWDvhmoz50XvBTpRdCoMPP9xS17tgDmb4wl2lEjzCqv4aQ+nGcsI7a5kDNTBnugZstcUwYV6jYskP2b0kO1MABTjF3PWTmZgQKBgQDI+XXKU5eg8gP0BByKYFZhT0/yY9Loz+Sjl5mSFa9mGudnivZVvRN+WcUQnde16ZXk72/DrI2Ox2XQuCP9Hd39SPgqryNGa+PGiebNWUo9aRiLHLs09nOJ+nmrSr2kCbs0F8+1+HZWVg4zjjlHJumtlG5IIiNhGB/07VBuOKyZQQKBgQC/tzOQ1m2kjsWsgtAi5mvPQjnzkNgsTnE4R0EyhfXg//KeYlWJxet80wy4xWyP6/lgM61bpPHcDk7JvNy7SURnz+YXOHZgdEk6eK7RvGG5ORBrvPfizKViGhGw302JW6nhE8fZbkROC7vH0TV3Wuu6wFc8KHB6GqnLkiOS0SE3xwKBgEZG3Uar5njUSEea7HQC7hHHDzi+aXEZyWTfTUdFJ/l3bPXLJQqkPF3RfFSsLVMiZFUS2S0+eJ214keTLJqFSCwayRT7+0TT02mIrVmfYJOK3Zc/q8MAbzSPjt40G45yDLFRpkOGp7LXEs46bJMR62LUZZ/5uA9qxTn7hkWUsd5BAoGAEJGkwz/E+hPcwawMkPeZGbB/ka1TAYFGB7cgy10IgwmbzlRxUBbq4z7aOp3VZBrg0o+ky+bVgE88P/MyoH0UjGRLXnZixLNIIOWNNlMxnvBvmuAaDF/jazcVkFO8P8LMS8eJ3iDJhnU9JWfPVyFkfh9harGUBvmG8zEOIgIw/MECgYEAjt8mtaEruCOFKtjfy4ifpkMT6T09JAVZBFwq9oEJY7xnczzUptKSM/ZQoRHpaOofL/6EE7KX0IlzBhJGOOS7UR2nIxGu5+BghptHRDRk8YK+V6gKGicdJc88ONJOwIpTWfbbjN5r19aqUHHiI4zkOw5ZYwQe2QM2klCTbP4HG3E=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAloHxsI8gDs0GWVM/U3MYBHhWS0NWxQYvDF2jHi+QrDVNC0axyWhKM8auz3Q0+/zFU40W47eYU9WFby9rhx7O/+IBOYU/Ib0nOWOYlndLDmp9QZ6H+b21/0q/UkCVtdL9XLpA6j+00gsUzQ3lagLyP4Pr3kBM9GOnkENLQKzoCZbwb38RapmOR1odOMovEjdooukJfYGyjus8Ef8fGV6teGuIFj6IOGY2LKBUoX6cwiUukjsuOt/gVhnLV+7o/budJxGMX8ZO+fCx6BUGmL7j2TOQ76qR3KLlyRCqjXBqh27bEgJQVYtW9IrtYcu9De5SR8I5KWFc1jKYsLVK9XkYhwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://f051f38d.ngrok.io/";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://eda98bc.ngrok.io/index/hangkong/index";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	//public static String log_path = "C:\\";


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

