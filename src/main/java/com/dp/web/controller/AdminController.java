package com.dp.web.controller;

import com.dp.entity.Admin;
import com.dp.service.IAdminService;
import com.dp.service.impl.AdminServiceImpl;
import com.dp.util.StringUtil;
import com.dp.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/admin")
public class AdminController extends BaseController {


    private IAdminService service = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String op = req.getParameter("op");
        if("add".equals(op)){
            doAdd(req,resp);
        }
        else if("findPage".equals(op)){
            doFindPage(req,resp);
        }  else if("delete".equals(op)){
            doshanchu(req,resp);
        }
        else if("adminlogin".equals(op)){
            doAdminlogin(req,resp);
        }

        else{
            resp.getWriter().print("no such Method......");
        }
    }

    private void doAdminlogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Map<String,Object> map =parseRequest(req);

        int m = service.adminlogin(map);
        printToJson(resp,m);


    }

    private void doshanchu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map =parseRequest(req);

        int m = service.delete(map);
        printToJson(resp,m);
    }


    private void doFindPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map =parseRequest(req);

        Map<String,Object> m = service.findPage(map);
        printToJson(resp,m);




    }


    /*
     *
     * 添加管理员
     * */
    protected void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Admin admin = parseRequest(req,Admin.class);
        ResultVO vo = service.add(admin);
        printToJson(resp,vo);

    }


}
