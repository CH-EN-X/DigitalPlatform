package com.dp.web.controller;

import com.dp.entity.ShippingAddress;
import com.dp.service.IShippingAddressService;
import com.dp.service.impl.ShippingAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/address")
public class ShippingAddressController extends BaseController{
    private IShippingAddressService service = new ShippingAddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String op = req.getParameter("op");
        if("addAddress".equals(op)){
            doAddAddress(req,resp);
        }else if("FindAll".equals(op)){
            doFindAll(req,resp);
        }else if("UpdateAddress".equals(op)){
            doUpdateAddress(req,resp);
        }else if("set".equals(op)){
            doSet(req,resp);
        }else if("DeleteAddress".equals(op)){
            doDeleteAddress(req,resp);
        }else{
            resp.getWriter().print("no such Methods...");
        }
    }

    private void doDeleteAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShippingAddress shippingAddress = parseRequest(req,ShippingAddress.class);
        printToJson(resp,service.delete(shippingAddress));
    }

    private void doSet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        ShippingAddress shippingAddress = parseRequest(req,ShippingAddress.class);
        printToJson(resp,service.set(shippingAddress));
    }

    private void doUpdateAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShippingAddress shippingAddress = parseRequest(req,ShippingAddress.class);
        printToJson(resp,service.UpdateAddress(shippingAddress));
    }

    private void doFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShippingAddress shippingAddress = parseRequest(req,ShippingAddress.class);
        printToJson(resp,service.FindAll(shippingAddress));
    }

    private void doAddAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShippingAddress shippingAddress = parseRequest(req, ShippingAddress.class);
        printToJson(resp,service.addAddress(shippingAddress));
    }
}
