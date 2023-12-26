package com.dp.web.controller;

import com.dp.entity.Parameter;
import com.dp.service.IParameterService;
import com.dp.service.impl.ParameterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/parameter")
public class ParameterController extends BaseController{

    private IParameterService parameterService = new ParameterServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String op = req.getParameter("op");
        if("FindByPid".equals(op)){
            doFindByPid(req,resp);
        }else if("FindPrice".equals(op)){
            doFindPrice(req,resp);
        }
        else if("find".equals(op)){
            doFind(req,resp);
        }
    }

    private void doFind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Parameter parameter = parseRequest(req,Parameter.class);
        printToJson(resp,parameterService.find(parameter));
    }



    private void doFindPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Parameter parameter = parseRequest(req, Parameter.class);
        printToJson(resp,parameterService.FindPrice(parameter));
    }

    private void doFindByPid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Parameter parameter = parseRequest(req, Parameter.class);
        printToJson(resp,parameterService.FindByPid(parameter));
    }
}
