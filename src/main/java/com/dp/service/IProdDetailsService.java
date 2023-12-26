package com.dp.service;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import com.dp.vo.ResultVO;

import java.util.List;
import java.util.Map;

public interface IProdDetailsService {


    ResultVO FindBalance(ProdDetails prodDetails);

    ResultVO FindName(ProdDetails prodDetails);


    Map<String,Object> finds(Map<String,Object> map);

    Map<String,Object> select(Map<String,Object> map);




}
