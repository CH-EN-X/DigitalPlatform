package com.dp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.Admin;
import com.dp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select( "select * from user")
    List<User> getUsersList( );

    int addUser( User user);

    List<User> Login(Map<String,Object> map);




    public List<User> finds(Map<String,Object> map);


    int total(Map<String,Object> map);



    int shanchu(Map<String ,Object> map);











}
