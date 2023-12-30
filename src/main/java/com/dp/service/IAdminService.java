package com.dp.service;

import com.dp.entity.Admin;
import com.dp.vo.ResultVO;

import java.util.Map;

public interface IAdminService {




    /*
     *
     * 添加
     * */
    ResultVO add(Admin admin);


    Map<String,Object> findPage(Map<String,Object> map);


    int delete(Map<String,Object> map);


    int adminlogin(Map<String,Object> map);




}
