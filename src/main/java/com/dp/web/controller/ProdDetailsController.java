package com.dp.web.controller;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import com.dp.entity.User;
import com.dp.service.IProdDetailsService;
import com.dp.service.impl.ProdDetailsServiceImpl;
import com.dp.util.FileUploadUtil;
import com.dp.util.StringUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/prodDetails")
public class ProdDetailsController extends BaseController{


    private IProdDetailsService service = new ProdDetailsServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        if(ServletFileUpload.isMultipartContent(req)){
            doAddGood(req,resp);
        }else {
            String op = req.getParameter("op");
            if (("finds").equals(op)) {
                doFinds(req, resp);
            } else if ("select".equals(op)) {
                doSelect(req, resp);
            } else if ("FindBalance".equals(op)) {
                doFindBalance(req, resp);
            } else if ("cpName".equals(op)) {
                doCpName(req, resp);
            } else if ("napName".equals(op)) {
                doNapName(req, resp);
            } else if ("FindName".equals(op)) {
                doFindName(req, resp);
            }   else if ("FindAll".equals(op)) {
                doFindAll(req, resp);
            }
            else if ("count".equals(op)) {
                doCount(req, resp);
            }
            else if ("recommend".equals(op)) {
                doRecommend(req, resp);
            }
            else if("FindPage".equals(op)){
                doFindPage(req,resp);
            }else if("BackDelete".equals(op)){
                doBackDelete(req,resp);
            }else if("BackUpdateStock".equals(op)){
                doBackUpdateStock(req,resp);
            }
            else {
                printToJson(resp, "NO method ......");
            }
        }
    }


    private void doBackUpdateStock(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdDetails prodDetails = parseRequest(req,ProdDetails.class);
        printToJson(resp,service.BackUpdateStock(prodDetails));
    }

    private void doBackDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdDetails prodDetails = parseRequest(req,ProdDetails.class);
        printToJson(resp,service.BackDelete(prodDetails));
    }

    private void doFindPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdDetails prodDetails = parseRequest(req, ProdDetails.class);
        String pageNum = req.getParameter("page");
        String pageSize = req.getParameter("limit");
        if(StringUtil.isNotNull(pageNum) && StringUtil.isNotNull(pageSize)){
            //做分页
            Map<String, Object> map = service.FindPage(prodDetails, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            printToJson(resp,map);
        } else {

        }
    }


    private void doRecommend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map =parseRequest(req);

        Map<String,Object> m =service.recommend(map);
        printToJson(resp,m);



    }

    private void doCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Map<String,Object> map =parseRequest(req);

        int m =service.update(map);
        printToJson(resp,m);



    }


    private void doFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        printToJson(resp,service.FindAll());
    }

    private void doAddGood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        ProdDetails prodDetails = FileUploadUtil.uploadFile(req, ProdDetails.class);
        prodDetails.setPImage("../"+prodDetails.getPImage());
        printToJson(resp,service.addGood(prodDetails));
    }



    private void doFindName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdDetails prodDetails = parseRequest(req, ProdDetails.class);
        printToJson(resp,service.FindName(prodDetails));
    }

    private void doNapName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> map =parseRequest(req);
        //得到session
        HttpSession session = req.getSession();
        //取出
        String pName = (String)session.getAttribute("pName");

        session.removeAttribute("pName");
        printToJson(resp,pName);


    }

    private void doCpName(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


        Map<String,Object> map =parseRequest(req);
        //得到session
        HttpSession session = req.getSession();

        //将用户名存入session
        session.setAttribute("pName",map.get("pName"));



        //取出
        Object pName = session.getAttribute("pName");


        printToJson(resp,pName);

    }


    private void doFindBalance(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdDetails prodDetails = parseRequest(req, ProdDetails.class);
        printToJson(resp,service.FindBalance(prodDetails));
    }

    private void doSelect(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{


        Map<String,Object> map =parseRequest(req);

        Map<String,Object> m =service.select(map);
        printToJson(resp,m);




    }

    private void doFinds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Map<String,Object> map =parseRequest(req);
        Map<String,Object> m =service.finds(map);
        printToJson(resp,m);

    }
}
