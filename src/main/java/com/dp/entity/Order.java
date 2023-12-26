package com.dp.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//aliPay

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    // 商户订单号,商户自定义，需保证在商户端不重复，如：20200612000001
    private String out_trade_no = getId();
    // 订单标题
    private String subject = "订单标题";
    // 订单金额，精确到小数点后两位
    private String total_amount = "99.99";

    private String timeout_express = "5m";

    private String product_code= "FAST_INSTANT_TRADE_PAY";
    private String getId() {
        LocalDateTime currentTime = LocalDateTime.now();

        // 使用自定义的格式化模式将时间转换为纯数字的字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }

    public void setProduct_code(String str){
        product_code=str;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
