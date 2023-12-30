package com.dp.common;

/**
 * 初始化方法参数&公共参数配置
 */
public class Config {

    /** 初始化代码配置信息  **/
    //（必填）支付宝网关
    //沙箱环境网关：https://openapi-sandbox.dl.alipaydev.com/gateway.do
    public static final  String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    //（必填）应用ID
    //请填写您的APPID:https://opendocs.alipay.com/common/02nebp
    public static final  String app_id = "9021000133622053";

    //（必填）应用私钥:https://opendocs.alipay.com/common/02kipk?pathHash=0d20b438
    //请填写您的应用私钥，例如：MIIEvQIBADANB ...
    public static final  String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCaKiTeSCASqjOlNDrkHvyO/q1gTRfhzlCHUc24dWuHs1VW2JASHQqvURe8azVh3G9p7EsSAV+djuRWZMb8ahrlzan0Ulq0PwNVf06N4xBntIrNKxPopHm8epggUK5llkTFTU6VlWWF2k9r1VmWM1RrjSMhXGBNrOAuLrFpTK/IvzyQVKDLckh/ceKPLoSpg3dnaFFinHy63phujpBAujqAayTe2bpOv8gNPl7T/+Ngh6jWweRRVAX322H0ROXPkfXDrL9zmWd0KJ7M3PAbQD0O1ECzGkZvldoouZYBB/ZhXog3aA1fNfE1IpPVcdviq5uDm9Dv9BRDHsk6DZzw7Ja5AgMBAAECggEAd9NIAsm2vCs0pzS4jXUUQyTqp45kgKt25icMKlKB+ODH9Q+ws5OFKY1zUI1X2a+XnZH/K4iLxBA7pHcCP1FNhM7dSbz1KWJM+hhQe3JA3wpyVFQmTk4BHSGAuqVbWDR7UYvsB9IuLeLoll0nG9rbxBjYdGazp8w2F09NsBXeD750RlLgxK+pFnexMVTopzMmf75ie6KFcBVUQNG2SwctekNdsitfw/Buv6wZ35U9BtcI7NZD0p2KItNCJuurI06hS6nPA3yjJpEloFpAi208520FUSuJk44xRR9bBVQWpet1q6yb8GZsMCR6RFJqFF7vWf349DIMNycY4wUs/5KKcQKBgQDm589QaVg0bkvQL8U8GW/VyWqWha6jFUHCai6gVKb3DM+Eh2RTJ9ewBRqgpR8gQxZ8oYgiZOTAxTkJRhe9I2UtMPPqig6mMRA1XjILbN7v6sfg8WEGnZ1HGmk7QAJrcoTiSpNfe3cP1gihs51CriaOHofJNi/9taJ9xY+MPcHw3QKBgQCq60Uvx3iyZLiI+3I4FU/VsCjJzdeYrDUZu0Wz8VWvPm7Atsd3ctAEiChwacrxYWXvw/PFv6ja53Q2GmySZD/bktJtxR+D26lerMoyyTKoKqCTaLnF8s8+n7oeMRzNJ9Hvlb7Vt7WXDgjm4sVF+NC4LQAxv8Bgizo6Tpqe5qlRjQKBgQDBOj1/whhBEAe7eS5pg7PVyM68lbQ13yT/h5HrM8vhM8Q42IA5Ij9ZmnvU8Tkh62JW+2oLtjjDpId9Xj2hVoxli/CiVdO6eZZhwqjIbNwHE4cek4ApZB5okQ58ua0Ms3HGWLgJEC3rf6YLg15XnZrAFYZ1+DWi76vB6mCc8FVqtQKBgCZCT9RoJD5aiWwwTNr8+kftDNRPfWkxcxl1cB7dcL6vjP8aav/z9VhuWg7/v2vUz4qiJFkpk9ScZskNlSwXwKuX6/6iV3GepAULTJ+dpfc6w4L7uEn1FisAehr0B2xs83Nb48HXQ5CylY+JR3toPOBdQmPgdmGmCLywh6/2FgSpAoGAJb2dPrRIUdlkfVPGnTlWca4FJpyb7tWWZhcRrbNBv21iQNHyQlScGB4oBD9EYIEL0C4ndYuuMNOyQu5U9jSQFp6KJT7Q9TrE5ayix/8AdvJShOrjrXSEvn6EqEcvHCGjt29TBmq7Sf3UneOTm+V+1n1aAFpIETCE/M61yxPsga0=";
    /********** RSA2公钥模式签名必用，公钥证书签名不传 ************/
    /**注：如果采用非证书模式，则无需赋值三个证书路径，改为赋值如下的支付宝公钥字符串即可**/
    //设置RSA2公钥方式：hhttps://opendocs.alipay.com/common/02kdnc?pathHash=fb0c752a

    //支付宝公钥
    //请填写您的支付宝公钥，例如：MIIBIjANBg...
    public static final  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjQs4nEnyqBbm+CyhqhEuf89c8Rq8Q/A2ypzImzy0l+DxV6L+AqufQA6e1voSiRE/qck1gTb0HXeUSeVayXcJcmXalaudKaTiMB8nDVuuYf0t3BsxJp94XcLqSVulNkc9LZ6T5ivkGF54Ai3R/YLFh1mnaxvuDKFKoifblYOq6x6K3reHnCA439ii9Lhd+/otZWf2xXVhzaA9JWQ/93Cnu3hLeuDmojRUOc7RwB5dzrhlN47aRQh75zBk944X2EsRqD2F8eQGVNRyvHZVZgSCG5nE1/FgBFF11bSVZve2vlx+2uyMFZ8Ek/Tsf7x5O3vdw0GhNB14LcRAbYGp3BkWeQIDAQAB";
    public static String sign_type = "RSA2";

    //（必填）编码格式
    public static String charset = "UTF-8";

    //请求格式，固定值json
    public static String format = "JSON";

    //调用的接口版本，固定为：1.0
    public static String version = "1.0";


    /** 代码中其他配置信息，根据各产品API公共参数选择性引用  **/
    //通过公共参数notify_url配置上传异步地址
    //异步通知地址需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，商户外网可以post访问的异步地址（不支持本地测试），用于接收支付宝返回的支付结果
    public static String notify_url ="";

    //通过接口公共参数return_url配置上传同步地址
    //同步通知地址需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，get访问，用于支付完成后前端页面同步跳转
    public static String return_url ="http://localhost:8088/DigitalPlatform/html/success.html";

    //日志记录目录
    public static String log_path = "D:/log.txt";


}