package com.dp.web.controller;




import com.dp.util.QrCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/qrcode")
//返回二维码图片字节流
public class QrCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        resp.setContentType("image/png;charset=UTF-8;");
        //获取二维码内容
        HttpSession session = req.getSession();
        //通过订单号获取二维码内容
//        String uid = (String) session.getAttribute("uid");
        String content = (String) session.getAttribute("qccode");
        System.out.print("图片内容:");
        System.out.println(content);
        if (content == null) {
            content = "fail";
        }
        //输出二维码
        OutputStream output = null;
        try {
            output = resp.getOutputStream();
            byte[] b = QrCodeUtils.buildQrCodeImage(content);
            output.write(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
