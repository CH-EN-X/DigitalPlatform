package com.dp.mapper;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import com.dp.entity.ProdType;

import java.util.List;
import java.util.Map;

public interface ProdTypeMapper {

    List<ProdDetails> finds(Map<String,Object> map);


    int total(Map<String,Object> map);

    List<ProdType> findType();



}
