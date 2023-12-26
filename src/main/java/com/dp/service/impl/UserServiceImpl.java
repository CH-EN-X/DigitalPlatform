package com.dp.service.impl;

import com.dp.entity.ProdDetails;
import com.dp.entity.User;
import com.dp.mapper.ProdDetailsMapper;
import com.dp.mapper.UserMapper;
import com.dp.service.IUserService;
import com.dp.util.MybatisPlusUtil;
import com.dp.util.MybatisUtil;
import com.dp.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements IUserService {



    private UserMapper mapper;
    @Override
    public int addUser( User user) {

        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(UserMapper.class);

        int x = mapper.addUser(user);
        System.out.println(x);

        return x;
    }

    @Override
    public Map<String,Object> Login(Map<String,Object> map) {


        System.out.println(map);
        if(null!=map && null!=map.get("u_phone") && null != map.get("u_pwd")){
            map.put("uPhone",map.get("u_phone").toString());
            map.put("uPwd",map.get("u_pwd").toString());
        }


        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(UserMapper.class);

        List<User> list = mapper.Login(map);
        System.out.println(list);

        //创建HashMap存储数据
        Map<String,Object> m = new HashMap<>();
        if(null == list || list.isEmpty()){
            m.put("code",600);
            m.put("msg","暂无数据");
        }
        else{
            m.put("code",200);
            m.put("msg","成功");
            m.put("data",list);

        }

        MybatisUtil.close(session);

        return m;



       /* SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(UserMapper.class);


        //判断用户名或密码是否为空
        if( StringUtil.isNull(user.getUPhone()) || StringUtil.isNull(user.getUPwd())){
            return  null;
        }


        List<User> list =mapper.Login(user);
        if( list== null || list.isEmpty()){
            return null;
        }

        System.out.println(list);
        return list.get(0);*/

    }



    @Override
    public User getUserById(Integer userId) {

        SqlSession session = MybatisPlusUtil.getSession();
        mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(userId);
        return user;
    }

    @Override
    public Integer updateUserById(User user) {
        SqlSession session = MybatisPlusUtil.getSession();
        mapper = session.getMapper(UserMapper.class);
        int updatedRows = mapper.updateById(user);
        return updatedRows;
    }


}
