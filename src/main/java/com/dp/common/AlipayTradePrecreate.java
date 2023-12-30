package com.dp.common;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.dp.entity.Order;


public class AlipayTradePrecreate {

    //传入订单类
    public static AlipayTradePrecreateResponse pay(Order Content) throws AlipayApiException {

        /** 引用初始化方法，Config配置链接：https://opensupport.alipay.com/support/FAQ/08d46c24-15a8-4f1c-85a0-68fdf587f813  **/
        AlipayClient alipayClient = new DefaultAlipayClient(Config.gatewayUrl, Config.app_id, Config.merchant_private_key, Config.format, Config.charset, Config.alipay_public_key, Config.sign_type);

        /** 实例化具体API对应的request类，类名称和接口名称对应,当前调用接口名称alipay.trade.precreate(统一收单线下交易预创建(扫码支付)) **/
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

        Content.setProduct_code("FACE_TO_FACE_PAYMENT");
        // 封装请求参数到biz_content
        request.setBizContent(Content.toString());
        /** 异步通知地址，以http或者https开头的，商户外网可以post访问的异步地址，用于接收支付宝返回的支付结果 **/
        //request.setNotifyUrl(common.Config.notify_url);

        /** 同步通知url **/
        //request.setReturnUrl(Config.return_url);

        AlipayTradePrecreateResponse response = alipayClient.execute(request);


        System.out.println(response);
        return  response;
    }




}