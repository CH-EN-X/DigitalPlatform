package com.dp.service;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import com.dp.vo.ResultVO;

import java.util.List;
import java.util.Map;

public interface IProdDetailsService {


    ResultVO FindBalance(ProdDetails prodDetails);

    ResultVO FindName(ProdDetails prodDetails);
    ResultVO addGood(ProdDetails prodDetails);

    ResultVO FindAll();

    int update(Map<String,Object> map);

    Map<String,Object> recommend(Map<String,Object> map);
    Map<String,Object> finds(Map<String,Object> map);

    Map<String,Object> select(Map<String,Object> map);


    Map<String, Object> FindPage(ProdDetails prodDetails, Integer pageNum, Integer pageSize);

    ResultVO BackDelete(ProdDetails prodDetails);

    ResultVO BackUpdateStock(ProdDetails prodDetails);


}
