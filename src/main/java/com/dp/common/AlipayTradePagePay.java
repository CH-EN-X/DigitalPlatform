package com.dp.common;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.dp.entity.Order;


public class AlipayTradePagePay {

    //pc端网页支付
    public static AlipayTradePagePayResponse pay(Order Content) throws AlipayApiException {

        /** 引用初始化方法，Config配置链接：https://opensupport.alipay.com/support/FAQ/08d46c24-15a8-4f1c-85a0-68fdf587f813  **/
        AlipayClient alipayClient = new DefaultAlipayClient(Config.gatewayUrl, Config.app_id, Config.merchant_private_key, Config.format, Config.charset, Config.alipay_public_key, Config.sign_type);

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        //product_code= "FAST_INSTANT_TRADE_PAY";
        Content.setProduct_code("FAST_INSTANT_TRADE_PAY");
        //通过content批量设置
        request.setBizContent(Content.toString());

        request.setProdCode("FAST_INSTANT_TRADE_PAY");
        /** 异步通知地址，以http或者https开头的，商户外网可以post访问的异步地址，用于接收支付宝返回的支付结果 **/
        //request.setNotifyUrl(common.Config.notify_url);

        /** 同步通知url **/
        request.setReturnUrl(Config.return_url);

        //使用alipayClient执行请求
        //返回一个AlipayTradePagePayResponse
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request, "GET");//支付url
        System.out.println(   response.getBody());
        //判断请求是否成功
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}