package com.dp.service;

import com.dp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserService {

    int addUser( User user);

    Map<String,Object> Login( Map<String,Object> map);


    User getUserById(Integer userId);

    Integer updateUserById(User user);

}
