package com.dp.web.controller;

import com.dp.entity.ShoppingCart;
import com.dp.service.IShoppingCartService;
import com.dp.service.impl.ShoppingCartServiceImpl;
import com.dp.vo.ResultVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart")
public class ShoppingCartController extends BaseController{

    private IShoppingCartService service = new ShoppingCartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String op = req.getParameter("op");
        if("addCart".equals(op)){
            doAddCart(req,resp);
        } else if("finds".equals(op)){
            doFinds(req,resp);
        } else if("increase".equals(op)){
            doIncrease(req,resp);
        } else if("reduce".equals(op)){
            doReduce(req,resp);
        } else if("remove".equals(op)){
            doRemove(req,resp);
        }else if("selected".equals(op)){
            doSelected(req,resp);
        }else if("selectCart".equals(op)){
            doSelectCart(req,resp);
        }else {
            resp.getWriter().print("no such Methods...");
        }
    }

    private void doSelectCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cId = Integer.parseInt(req.getParameter("cId"));
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        writer.write(gson.toJson(service.selectCart(cId)));
    }

    private void doSelected(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = parseRequest(req,ShoppingCart.class);
        printToJson(resp,service.selected(shoppingCart));
    }

    private void doRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = parseRequest(req,ShoppingCart.class);
        printToJson(resp,service.remove(shoppingCart));
    }

    private void doReduce(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = parseRequest(req,ShoppingCart.class);
        printToJson(resp,service.reduce(shoppingCart));
    }

    private void doIncrease(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = parseRequest(req,ShoppingCart.class);
        printToJson(resp,service.increase(shoppingCart));
    }

    private void doFinds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String uId = req.getParameter("uId");
//        System.out.println("uid = " + uId);
        ResultVO finds = service.finds(uId);
        printToJson(resp,finds);
    }

    private void doAddCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ShoppingCart shoppingCart = parseRequest(req, ShoppingCart.class);
        printToJson(resp,service.addCart(shoppingCart));
    }
}
