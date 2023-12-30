package com.dp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.Admin;
import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper extends BaseMapper<AdminMapper> {

    Integer add(@Param("obj")Admin admin);


    public List<Admin> findPage(Map<String,Object> map);


    int total(Map<String,Object> map);


    int shanchu(Map<String ,Object> map);


    int adminlogin(Map<String ,Object> map);



}
