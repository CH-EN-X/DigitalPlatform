package com.dp.mapper;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProdDetailsMapper {


    public List<ProdDetails> finds(Map<String,Object> map);


    List<ProdDetails> recommend(Map<String,Object> map);

    ProdDetails FindName(@Param("obj")ProdDetails prodDetails);

    Integer addGood(@Param("obj")ProdDetails prodDetails);


    List<ProdDetails> FindAll();


    int update(Map<String,Object> map);




    int ttal(Map<String,Object> map);


    Integer total(@Param("obj")ProdDetails prodDetails);


    ProdDetails FindBalance(@Param("obj") ProdDetails prodDetails);

    List<Map<String,Object>> FindPage(@Param("obj")ProdDetails prodDetails,
                                      @Param("page")Integer pageNum,@Param("limit")Integer pageSize);


    Integer BackDelete(@Param("obj")ProdDetails prodDetails);

    Integer BackUpdateStock(@Param("obj")ProdDetails prodDetails);

}
