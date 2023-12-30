package com.dp.util;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

public class MybatisPlusUtil {

    static SqlSessionFactory sqlSessionFactory = null;
    //获取sqlSession
    public static SqlSession getSession(){
        SqlSession session = null;
        InputStream ins = null;

        try{
            //加载主配置文件
            ins = Resources.getResourceAsStream("mybatis.xml");
            //获取Mybatis的SqlSession工厂
            sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(ins);
            //通过工厂获取session
            session = sqlSessionFactory.openSession(true);//true表示自动提交事务
            //调用session的查询集合方法
            return session;
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                ins.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    //关闭SqlSession
    public static void closeSession(SqlSession session){
        if (session != null){
            session.close();
        }
    }
}