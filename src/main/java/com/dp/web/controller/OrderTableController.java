package com.dp.web.controller;

import com.dp.entity.OrderDetails;
import com.dp.entity.OrderTable;
import com.dp.entity.ShoppingCart;
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
import java.util.List;
import java.util.Map;

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
        } else if("addOrder".equals(op)){
            doAdd(req,resp);
        } else{
            printToJson(resp,"NO method ......");
        }
    }

    private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderTable orderTable = new OrderTable();
        orderTable.setUId(Integer.valueOf(req.getParameter("uId")));
        orderTable.setAId(Integer.valueOf(req.getParameter("aId")));
        orderTable.setTotalPrice(Integer.valueOf(req.getParameter("totalPrice")));
        //发货状态
        orderTable.setOState(0);

        printToJson(resp,service.add(orderTable));

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOId(orderTable.getOId());
        orderDetails.setParamId(Integer.valueOf(req.getParameter("paramId")));
        orderDetails.setPNumber(Integer.valueOf(req.getParameter("pNumber")));
        orderDetails.setOPrice(Integer.valueOf(req.getParameter("oPrice")));
        printToJson(resp,serviceDetails.add(orderDetails));


//        Map<String,Object> list = parseRequest(req);
//        System.out.println("list ======= " + list);
//        OrderTable order = parseRequest(req,OrderTable.class);
//        OrderDetails orderDetails = parseRequest(req,OrderDetails.class);
//
//        //先插入OrderTable，获取自增的oId赋给
//        printToJson(resp,service.add(order));
//        orderDetails.setOId(10);//orderDetails.setOId(order.getOId());
//        //再插入OrderDetails
//        printToJson(resp,serviceDetails.add(orderDetails));
    }

    private void doFinds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderTable order = parseRequest(req,OrderTable.class);

        int uId = Integer.parseInt(req.getParameter("uId"));
        order.setUId(uId);

        printToJson(resp,service.finds(order));
    }
}
