package com.dp.service;

import com.dp.vo.ResultVO;

import java.util.Map;

public interface IProdTypeService {


    Map<String,Object> finds(Map<String,Object> map);



    ResultVO findType();

}
