package com.dp.web.controller;


import com.dp.entity.User;
import com.dp.service.IUserService;
import com.dp.service.impl.UserServiceImpl;
import com.dp.vo.ResultVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/user")
public class UserController  extends  BaseController{

    @Autowired
    private IUserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String op = req.getParameter("op");
        if("login".equals(op)){
            doLogin(req,resp);
        }
        else if("adduser".equals(op)){
            doAddUser(req,resp);
        }
        else if("findById".equals(op)){
            doFindById(req,resp);
        } else if ("updateInfo".equals(op)) {
            doUpdateById(req, resp);
        } else if ("lg".equals(op)) {
            doLg(req, resp);
        }
        else if ("determine".equals(op)) {
            doDetermine(req, resp);
        }
        else if ("remember".equals(op)) {
            doRemember(req, resp);
        }
        else if ("forgot".equals(op)) {
            doForgot(req, resp);
        }
        else if ("eject".equals(op)) {
            doEject(req, resp);
        }
        else{
            printToJson(resp,"NO method ......");
        }
    }

    private void doEject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Map<String,Object> map =parseRequest(req);
        //得到session
        HttpSession session = req.getSession();

        //取出
        String uPhone = (String)session.getAttribute("uPhone");
        System.out.println(uPhone);
        String uPwd="";
        if(uPhone.equals(map.get("uPhone").toString())){

             uPwd = (String)session.getAttribute("uPwd");
        }


        printToJson(resp,uPwd);



    }

    private void doForgot(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        Map<String,Object> map =parseRequest(req);
        //得到session
        HttpSession session = req.getSession();

        session.removeAttribute("uPhone");
        session.removeAttribute("uPwd");

        //取出
        String uPhone = (String)session.getAttribute("uPhone");


        printToJson(resp,uPhone);



    }

    private void doRemember(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map =parseRequest(req);
        //得到session
        HttpSession session = req.getSession();
        //设置最长访问间隔时间
        session.setMaxInactiveInterval(60*60*24);
        //将用户名存入session
        session.setAttribute("uPhone",map.get("uPhone"));
        session.setAttribute("uPwd",map.get("uPwd"));


        printToJson(resp,1);





    }

    private void doDetermine(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{

        Map<String,Object> map =parseRequest(req);
        //得到session
        HttpSession session = req.getSession();
        //取出
        int uId = Integer.parseInt((String)session.getAttribute("uId"));

        printToJson(resp,uId);


    }

    private void doLg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


        Map<String,Object> map =parseRequest(req);
        //得到session
        HttpSession session = req.getSession();
        //设置最长访问间隔时间
        session.setMaxInactiveInterval(60*60*24);
        //将用户名存入session
        session.setAttribute("uId",map.get("uId"));



        //取出
        Object uId = session.getAttribute("uId");


        System.out.println(uId);


        printToJson(resp,uId);

    }


    private void doUpdateById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到session
        HttpSession session = req.getSession();
        //取出
        int uId = Integer.parseInt((String)session.getAttribute("uId"));

        Gson gson = new Gson();
        BufferedReader reader = req.getReader();
        User user = gson.fromJson(reader, User.class);
        user.setUId(uId);
        service.updateUserById(user);

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("User updated successfully");
    }

//    private void doUpdateById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("req = " + req);
////        User user = new Gson().fromJson((JsonReader) req, User.class);
//        User user = parseRequest(req,User.class);
//        service.updateUserById(user);
//    }

        private void doFindById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            //得到session
            HttpSession session = req.getSession();
            //取出用户名
            int uId = Integer.parseInt((String)session.getAttribute("uId"));


            User user = parseRequest(req,User.class);
            //System.out.println("id ===="+req.getParameter("id"));
            int id = uId;
            User vo = service.getUserById(id); //TODO 登录时获取id token
            //System.out.println("vo = " + vo);
            printToJson(resp,vo);




        }




    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        Map<String,Object> map =parseRequest(req);
        Map<String,Object> m =service.Login(map);



        printToJson(resp,m);



    }


    /*
    * 注册
    * */
    private void doAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String u_pwd = req.getParameter("u_pwd");
        String u_phone = req.getParameter("u_phone");

        User user = parseRequest(req,User.class);//解析请求
        user.setUPwd(u_pwd);
        user.setUPhone(u_phone);
        int x = service.addUser(user);
        printToJson(resp,x);




    }

}
