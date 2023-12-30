package com.dp.service;

import com.dp.entity.Mark;

import java.util.Map;

public interface IMarkService {


    int insert(Mark mark);



    Map<String,Object> finds(Map<String,Object> map);
    Map<String,Object> find(Map<String,Object> map);



}
