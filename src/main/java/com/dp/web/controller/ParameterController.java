package com.dp.web.controller;

import com.dp.entity.Parameter;
import com.dp.service.IParameterService;
import com.dp.service.impl.ParameterServiceImpl;
import com.dp.util.FileUploadUtil;
import com.dp.util.StringUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/parameter")
public class ParameterController extends BaseController{

    private IParameterService parameterService = new ParameterServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        if(ServletFileUpload.isMultipartContent(req)){
            doAdd(req,resp);
        }else {
            String op = req.getParameter("op");
            if ("FindByPid".equals(op)) {
                doFindByPid(req, resp);
            } else if ("FindPrice".equals(op)) {
                doFindPrice(req, resp);
            } else if ("find".equals(op)) {
                doFind(req, resp);
            } else if ("FindAll".equals(op)) {
                doFindAll(req, resp);
            }
            else if("FindPage".equals(op)){
                doFindPage(req,resp);
            }else if("BackDelete".equals(op)){
                doBackDelete(req,resp);
            }else if("BackUpdatePrice".equals(op)){
                doBackUpdatePrice(req,resp);
            }
            else {
                resp.getWriter().print("no such Methods...");
            }
        }
    }


    private void doBackUpdatePrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Parameter parameter = parseRequest(req,Parameter.class);
        printToJson(resp,parameterService.BackUpdatePrice(parameter));
    }

    private void doBackDelete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        Parameter parameter = parseRequest(req,Parameter.class);
        printToJson(resp,parameterService.BackDelete(parameter));
    }

    private void doFindPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Parameter parameter = parseRequest(req,Parameter.class);
        String pageNum = req.getParameter("page");
        String pageSize = req.getParameter("limit");
        if(StringUtil.isNotNull(pageNum) && StringUtil.isNotNull(pageSize)){
            //做分页
            Map<String, Object> map = parameterService.FindPage(parameter, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            printToJson(resp,map);
        } else {

        }
    }



    private void doFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printToJson(resp,parameterService);
    }

    private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Parameter parameter = FileUploadUtil.uploadFile(req,Parameter.class);
        parameter.setParamImage("../"+parameter.getParamImage());
        printToJson(resp,parameterService.doAdd(parameter));
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
