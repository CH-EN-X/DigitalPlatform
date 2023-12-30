package com.dp.web.controller;

import com.dp.util.StringUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController extends HttpServlet {

    private static final long serialVersionUID = -2389739834791647136L;

    /*
    * 解析请求对象  获取请求对象中数据后存储到指定实体类对象中
    *
    *
    * */
    public <T> T parseRequest(HttpServletRequest request, Class<T> cls){

        T t = null;
        //通过反射获取所有的属性  所有的方法
        Field[] fields =cls.getDeclaredFields();
        Method[] methods =cls.getDeclaredMethods();
        //通过反射获取无参构造方法对象 创建对象
        Constructor<T> cs =null;

        try {
            cs=cls.getConstructor();
            t = cs.newInstance();//调用无参构造方法创建对象
            //循环字段
            for (Field f : fields){
                String fieldName = f.getName();
                String value = request.getParameter(fieldName);
                if(StringUtil.isNull(value)){
                    continue;
                }
                System.out.println(fieldName +"=" +value);
                //循环方法
                for (Method m: methods){
                    String methodName = m.getName();
                    if (("set"+fieldName).equalsIgnoreCase(methodName)){
                        //获取set方法的形参数据类型
                        String typeName = m.getParameterTypes()[0].getSimpleName();
                        System.out.println(typeName);

                        if("int".equals(typeName)  || "Integer".equals(typeName)){
                            m.invoke(t,Integer.parseInt(value));
                        }
                        else if ("long".equals(typeName) || "Long".equals(typeName)){
                            m.invoke(t,Long.parseLong(value));
                        }
                        else if("float".equals(typeName) || "Float".equals(typeName)){
                            m.invoke(t,Float.parseFloat(value));

                        }
                        else  if("double".equals(typeName) || "Double".equals(typeName)){
                            m.invoke(t,Double.parseDouble(value));

                        }
                        else{
                            m.invoke(t,value);

                        }


                    }
                }


            }

        } catch (Exception e) {
            System.out.println("解析请求异常：" + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println(t);
        return t;
    }


    /*
    *
    * 解析请求对象 返回map对象
    * */
    public Map<String,Object> parseRequest(HttpServletRequest request){
        Map<String,Object> map =new HashMap<>();
        //获取请求对象中所有参数名
        Enumeration<String> names =request.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            //根据参数名获取值
            String value =request.getParameter(name);
            //name作为键
            map.put(name,value);

        }
        System.out.println(map);
        return map;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doGet(req,resp);
    }

    public void printToJson(HttpServletResponse resp,Integer value) throws IOException{
        PrintWriter out = resp.getWriter();
        out.print(value);

    }


    public void printToJson(HttpServletResponse resp,String value) throws IOException{
        PrintWriter out = resp.getWriter();
        out.print(value);

    }


    public void printToJson(HttpServletResponse resp,Object obj) throws IOException{
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String str = gson.toJson(obj);
        out.print(str);


    }


}
