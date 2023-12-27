package com.dp.web.controller;

import com.dp.entity.OrderDetails;
import com.dp.entity.OrderTable;
import com.dp.service.OrderDetailsService;
import com.dp.service.OrderTableService;
import com.dp.service.impl.OrderDetailsServiceImpl;
import com.dp.service.impl.OrderTableServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/order")
public class OrderTableController extends BaseController{

    @Autowired
    private OrderTableService service = new OrderTableServiceImpl();

    @Autowired
    private OrderDetailsService serviceDetails = new OrderDetailsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String op = req.getParameter("op");
        if("finds".equals(op)){
            doFinds(req,resp);
        } else if("insert".equals(op)){
            doAdd(req,resp);
        } else{
            printToJson(resp,"NO method ......");
        }
    }

    private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderTable order = parseRequest(req,OrderTable.class);
        OrderDetails orderDetails = parseRequest(req,OrderDetails.class);

        //先插入OrderTable，获取自增的oId赋给
        printToJson(resp,service.add(order));
        orderDetails.setOId(order.getOId());
        printToJson(resp,serviceDetails.add(orderDetails));
    }

    private void doFinds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderTable order = parseRequest(req,OrderTable.class);

        //得到session
        HttpSession httpSession = req.getSession();
        //取出
        int uId = (Integer) httpSession.getAttribute("uId");
        //order.setUId(2);

//        PrintWriter writer = resp.getWriter();
//        Gson gson = new Gson();
//        writer.write(gson.toJson(service.finds(order)));

        printToJson(resp,service.finds(order));
    }
}
