package com.dp.util;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/*
* 文件上传工具类
* */
public class FileUploadUtil {

    private static final long FILEMAXSIZE = 1024*10 * 10;
    private static final String FILEPATH = "/dig_pics";//文件的项目名
    private static String picsPath="";//图片路径
    private static Method method=null;//存储的与图片相关的set方法


    /*
    *
    * 文件上传
    * */
    public static <T> T uploadFile(HttpServletRequest req,Class<T> cls){

        T t =null;
        Constructor<T> cs =null;
        //获取所有的成员方法
        Method[] methods = cls.getDeclaredMethods();
        //获取磁盘项文件工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //获取文件上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);


        try {
            cs =cls.getConstructor();
            t = cs.newInstance();//创建文件
            //解析请求
            List<FileItem> list = upload.parseRequest(req);
            //循环所有的表单元素
            for (Method m : methods){
                for(FileItem f:list){

                    String fieldName = f.getFieldName();//获取表单元素 name属性值
                    if(("set"+fieldName).equalsIgnoreCase(m.getName())){
                        setValue(req,m,t,f);
                    }

                }
            }
            //所有元素遍历完成  最后设置图片路径

            if(methods!=null && StringUtil.isNotNull(picsPath)){
                if(picsPath.lastIndexOf(";") == picsPath.indexOf(";")){
                    picsPath =picsPath.substring(0,picsPath.indexOf(";"));
                }
                method.invoke(t,picsPath);

            }
            method = null;
            picsPath="";




        } catch ( Exception e) {
            System.out.println("文件上传封装代码异常：" + e.getMessage());
            throw new RuntimeException(e);
        }
        return t;


    }



    private static <T> void setValue(HttpServletRequest req,Method m,T t,FileItem f) throws Exception{

        if(f.isFormField()){//是否为普通表单元素
            String name = f.getFieldName();
            String value =f.getString("UTF-8");
            //获取类型
            String typeName = m.getParameterTypes()[0].getSimpleName();


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
        else{
            method = m;//将图片设置的set方法对象赋给method全局变量
            //文件
            String imageName = System.nanoTime() + f.getName();

            //获取服务器路径
            String path = req.getServletContext().getRealPath("/") + ".." + FILEPATH;
            File file = new File(path,imageName);
            //将图片数据写入服务器
            f.write(file);
            picsPath += ".." + FILEPATH + "/" + imageName + ";";
            //
        }







    }







}
