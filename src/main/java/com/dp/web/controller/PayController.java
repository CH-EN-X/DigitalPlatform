package com.dp.web.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.dp.common.AlipayTradePagePay;
import com.dp.common.AlipayTradePrecreate;
import com.dp.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/pay")
public class PayController extends HttpServlet {

    //电脑端网页支付
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String total_amount = req.getParameter("total_amount");  // 从前端获取金额参数
        Order Content = new Order();  // 将金额传递给Order对象
        Content.setTotal_amount(total_amount);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        try {
            /** 获取接口调用结果 **/
            AlipayTradePagePayResponse payResponse = AlipayTradePagePay.pay(Content);
            // payResponse.getOutTradeNo();//商户的自定义订单号
            //payResponse.getTradeNo()//支付宝交易号
            String str=payResponse.getBody();
            System.out.println(str);
            resp.setStatus(200);

            resp.getWriter().write(str);

//          resp.sendRedirect( payResponse.getBody());
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String total_amount = req.getParameter("total_amount");  // 从前端获取金额参数
        Order Content = new Order();  // 将金额传递给Order对象
        Content.setTotal_amount(total_amount);

        try {
            /** 获取接口调用结果 **/
            AlipayTradePrecreateResponse payResponse = AlipayTradePrecreate.pay(Content);
            // payResponse.getOutTradeNo();//商户的自定义订单号
            HttpSession session = req.getSession();
            session.setAttribute("qccode", payResponse.getQrCode());
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        resp.setStatus(200);
    }
}
