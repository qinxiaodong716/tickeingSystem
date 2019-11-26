package config;


import util.IP;

public class AlipayConfig {
	
	// 商户appid
	public static String APPID = "2016101000649938";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDMG9swBTniJATC9vUPOtr4i6XKpj0nfMUqDID1Ye1rxiZThRAd/h+APS5nPghoH1KZvykilBdMQQIDOAlKK5R42MuErVnbZjL8plFzUwCoxwfZT9k5NxbSc/rtGJxxlyRRzrpJCd4+tkdjP7bQ+Qacz8tkDVi2t1DQdSlmipwUuLj6VRUDxZWAe8O7KrfSK9XxDJNEohh4yVRx7Hkz5woKKmj/ovgH1Xk/1rkaNurIauvdHNhrers7haOsHnSH3KsQTA9AczdynHtok5ep4r2hyMt4Mf8Lp3oImVLCJEzDpcRkFCr+RpEBnCJsYBbc37/8h2+HRBPhhQIrqrZY+81vAgMBAAECggEBALNWOnVr8hr3iNOBR3rVPLarhMWU4SDD6Tzz9Y8lNwW9+cjinnGr6iO0HgSKpbpO4zXBl7QRKJNQfyMy5j6sIe04l0GBSvWSS3Rf8isBIBArqILRPMyf0caiLzSJrlPD+B6FJHquV/8EC59xyQC9/Yhkr5G+hFcupKw0dWbqnQ86WQf/+SDSX6Dgc480SYcINuBNkRGr2AHTgyz3y2FZOVD7lp6lscsLIvDNrgGT3njuPZrDFqnjWJRQJH6GT6yblvrrMct81K3kmQsv78rA9/6rK4VrkPL/fU98ktNrq3Cj2XqxvuhtGFUDpRDneICdNfBzRZBWl7NdrD4+vcy83mkCgYEA7nL226wlrRKIDWaY1YJY3kJTyb+g7BzyAwZ/rsbyppOkx0CJUkXLu7RBYSz6+8caUQLh8hlHHCR089fJ80JMO46OGjVzBXa4feXxz2zIBrZdBtSnZ8KWDvXBnEOg/We0ZFVetmgq6IgbmEDvteh9qWJ75G8wZI2NwJockbMDzT0CgYEA2yHTs9m39Ry0mAi3kCFt6C/OjUz75uwE5DiHswgJqJSKSKpywHgfit9umXuQyPxlCibnKFPNVNats/KaJHVB0ZLQHWzZXYJWgkCsv/0eHdzbHsGScwzMpmFOacYXg6zpgpk7rvefCkkETFp7SWxAPF/YQcxwx2JYoPq001MMSBsCgYAVPax72RPqHPJ9rxwCOQBNnD72g9mD7vgoCNYq7ZIEALb3AOq6p3kEmYQRcf5Rm2TevpD+Df5lpWG9rwVQZCGCVKqX7xb176Nzo54syhXvcyNKTnszJQRVBNNgZi3bJPfO0EQFn7XizO0YXQB9hd5bzmgW60i2TF3KQHA3EmlOSQKBgHAV42WRLakwn6dMfig5ETC8k1hvUkIR44ag67hFmjsij4EPvlZ4mxm7o6TaMXq8ryn8MCzOgK6uiHcM1o9jcuExyUXj0WMlMf65+iLR47++ok4fETvMBjnsd+Fes9Rkc6SboI2klzL5mjs75OfveQPouoMdgWpbAZ6F3kxhpFyVAoGAFQPcEdUSYJeztrgZggXrRce2EZBK6ATYjTbL4dagzOREESTRJtp8eCvbXhB0dmYlM1WgUPIBvS67hYkCR19KFHSmCU/PED1+sKwpHI67aykR6nGWw9tesDVmsZ+3EduP7KBE85496IKDcCco4bIx7uOXJATp171MfRBJjspmjy4=";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = IP.ip+"/index/";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzBvbMAU54iQEwvb1Dzra+IulyqY9J3zFKgyA9WHta8YmU4UQHf4fgD0uZz4IaB9Smb8pIpQXTEECAzgJSiuUeNjLhK1Z22Yy/KZRc1MAqMcH2U/ZOTcW0nP67RiccZckUc66SQnePrZHYz+20PkGnM/LZA1YtrdQ0HUpZoqcFLi4+lUVA8WVgHvDuyq30ivV8QyTRKIYeMlUcex5M+cKCipo/6L4B9V5P9a5GjbqyGrr3RzYa3q7O4WjrB50h9yrEEwPQHM3cpx7aJOXqeK9ocjLeDH/C6d6CJlSwiRMw6XEZBQq/kaRAZwibGAW3N+//Idvh0QT4YUCK6q2WPvNbwIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
