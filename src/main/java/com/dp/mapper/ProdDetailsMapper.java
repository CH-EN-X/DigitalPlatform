package com.dp.mapper;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProdDetailsMapper {


    public List<ProdDetails> finds(Map<String,Object> map);

    ProdDetails FindName(@Param("obj")ProdDetails prodDetails);




    int total(Map<String,Object> map);


    ProdDetails FindBalance(@Param("obj") ProdDetails prodDetails);


}
