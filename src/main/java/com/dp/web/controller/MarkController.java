package com.dp.web.controller;


import com.dp.entity.Mark;
import com.dp.entity.User;
import com.dp.service.IMarkService;
import com.dp.service.impl.MarkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/mark")
public class MarkController extends BaseController{



    private IMarkService service = new MarkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String op = req.getParameter("op");
        if("finds".equals(op)){
            doFinds(req,resp);
        }
        else if("insert".equals(op)){
            doInsert(req,resp);
        }
        else if("find".equals(op)){
            doFind(req,resp);
        }


    }

    private void doFind(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException  {

        Map<String,Object> map =parseRequest(req);
        Map<String,Object> m =service.find(map);
        printToJson(resp,m);




    }

    private void doInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pId = Integer.parseInt(req.getParameter("pId"));
        String markDetails = req.getParameter("markDetails");
        String rating = req.getParameter("rating");

        Mark mark = parseRequest(req, Mark.class);//解析请求
        mark.setPId(pId);
        mark.setMarkDetails(markDetails);

        //得到session
        HttpSession session = req.getSession();
        //设置最长访问间隔时间
        session.setMaxInactiveInterval(60*60*24);

        //取出
        int uId = Integer.parseInt((String)session.getAttribute("uId"));
        mark.setUId(uId);

        mark.setRating(rating);
        int x = service.insert(mark);
        printToJson(resp,x);









    }

    private void doFinds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {

        Map<String,Object> map =parseRequest(req);
        Map<String,Object> m =service.finds(map);
        printToJson(resp,m);




    }




}
