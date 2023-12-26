package com.dp.web.controller;


import com.dp.service.IProdTypeService;
import com.dp.service.impl.ProdTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/type")
public class ProdTypeController extends BaseController {

    private IProdTypeService service = new ProdTypeServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String op = req.getParameter("op");
        if(("finds").equals(op)){
            doFinds(req,resp);
        }

        else{
            printToJson(resp,"NO method ......");
        }

    }

    private void doFinds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> map =parseRequest(req);
        Map<String,Object> m =service.finds(map);
        printToJson(resp,m);


    }
}
