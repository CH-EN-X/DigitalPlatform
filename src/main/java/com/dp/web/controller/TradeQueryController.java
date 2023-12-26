package com.dp.web.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queryTrade")
public class TradeQueryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCaKiTeSCASqjOlNDrkHvyO/q1gTRfhzlCHUc24dWuHs1VW2JASHQqvURe8azVh3G9p7EsSAV+djuRWZMb8ahrlzan0Ulq0PwNVf06N4xBntIrNKxPopHm8epggUK5llkTFTU6VlWWF2k9r1VmWM1RrjSMhXGBNrOAuLrFpTK/IvzyQVKDLckh/ceKPLoSpg3dnaFFinHy63phujpBAujqAayTe2bpOv8gNPl7T/+Ngh6jWweRRVAX322H0ROXPkfXDrL9zmWd0KJ7M3PAbQD0O1ECzGkZvldoouZYBB/ZhXog3aA1fNfE1IpPVcdviq5uDm9Dv9BRDHsk6DZzw7Ja5AgMBAAECggEAd9NIAsm2vCs0pzS4jXUUQyTqp45kgKt25icMKlKB+ODH9Q+ws5OFKY1zUI1X2a+XnZH/K4iLxBA7pHcCP1FNhM7dSbz1KWJM+hhQe3JA3wpyVFQmTk4BHSGAuqVbWDR7UYvsB9IuLeLoll0nG9rbxBjYdGazp8w2F09NsBXeD750RlLgxK+pFnexMVTopzMmf75ie6KFcBVUQNG2SwctekNdsitfw/Buv6wZ35U9BtcI7NZD0p2KItNCJuurI06hS6nPA3yjJpEloFpAi208520FUSuJk44xRR9bBVQWpet1q6yb8GZsMCR6RFJqFF7vWf349DIMNycY4wUs/5KKcQKBgQDm589QaVg0bkvQL8U8GW/VyWqWha6jFUHCai6gVKb3DM+Eh2RTJ9ewBRqgpR8gQxZ8oYgiZOTAxTkJRhe9I2UtMPPqig6mMRA1XjILbN7v6sfg8WEGnZ1HGmk7QAJrcoTiSpNfe3cP1gihs51CriaOHofJNi/9taJ9xY+MPcHw3QKBgQCq60Uvx3iyZLiI+3I4FU/VsCjJzdeYrDUZu0Wz8VWvPm7Atsd3ctAEiChwacrxYWXvw/PFv6ja53Q2GmySZD/bktJtxR+D26lerMoyyTKoKqCTaLnF8s8+n7oeMRzNJ9Hvlb7Vt7WXDgjm4sVF+NC4LQAxv8Bgizo6Tpqe5qlRjQKBgQDBOj1/whhBEAe7eS5pg7PVyM68lbQ13yT/h5HrM8vhM8Q42IA5Ij9ZmnvU8Tkh62JW+2oLtjjDpId9Xj2hVoxli/CiVdO6eZZhwqjIbNwHE4cek4ApZB5okQ58ua0Ms3HGWLgJEC3rf6YLg15XnZrAFYZ1+DWi76vB6mCc8FVqtQKBgCZCT9RoJD5aiWwwTNr8+kftDNRPfWkxcxl1cB7dcL6vjP8aav/z9VhuWg7/v2vUz4qiJFkpk9ScZskNlSwXwKuX6/6iV3GepAULTJ+dpfc6w4L7uEn1FisAehr0B2xs83Nb48HXQ5CylY+JR3toPOBdQmPgdmGmCLywh6/2FgSpAoGAJb2dPrRIUdlkfVPGnTlWca4FJpyb7tWWZhcRrbNBv21iQNHyQlScGB4oBD9EYIEL0C4ndYuuMNOyQu5U9jSQFp6KJT7Q9TrE5ayix/8AdvJShOrjrXSEvn6EqEcvHCGjt29TBmq7Sf3UneOTm+V+1n1aAFpIETCE/M61yxPsga0=";
            String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjQs4nEnyqBbm+CyhqhEuf89c8Rq8Q/A2ypzImzy0l+DxV6L+AqufQA6e1voSiRE/qck1gTb0HXeUSeVayXcJcmXalaudKaTiMB8nDVuuYf0t3BsxJp94XcLqSVulNkc9LZ6T5ivkGF54Ai3R/YLFh1mnaxvuDKFKoifblYOq6x6K3reHnCA439ii9Lhd+/otZWf2xXVhzaA9JWQ/93Cnu3hLeuDmojRUOc7RwB5dzrhlN47aRQh75zBk944X2EsRqD2F8eQGVNRyvHZVZgSCG5nE1/FgBFF11bSVZve2vlx+2uyMFZ8Ek/Tsf7x5O3vdw0GhNB14LcRAbYGp3BkWeQIDAQAB";
            AlipayConfig alipayConfig = new AlipayConfig();
            alipayConfig.setServerUrl("https://openapi-sandbox.dl.alipaydev.com/gateway.do");
            alipayConfig.setAppId("9021000133622053");
            alipayConfig.setPrivateKey(privateKey);
            alipayConfig.setFormat("json");
            alipayConfig.setAlipayPublicKey(alipayPublicKey);
            alipayConfig.setCharset("UTF-8");
            alipayConfig.setSignType("RSA2");

            AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            AlipayTradeQueryModel model = new AlipayTradeQueryModel();

            // 从请求中获取参数tradeNo
            String tradeNo = req.getParameter("trade_no");
            model.setTradeNo(tradeNo);
            request.setBizModel(model);

            AlipayTradeQueryResponse response = alipayClient.execute(request);

            PrintWriter writer = resp.getWriter();
            writer.write(response.getBody());

            System.out.println("response.getBody() ==== " +response.getBody());

        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }


    }

}
