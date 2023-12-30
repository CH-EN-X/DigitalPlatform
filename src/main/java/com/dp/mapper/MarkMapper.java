package com.dp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.Mark;
import com.dp.entity.ProdDetails;

import java.util.List;
import java.util.Map;

public interface MarkMapper extends BaseMapper<Mark> {


    int insert(Mark mark);


    List<Mark> finds(Map<String,Object> map);

    List<ProdDetails> find(Map<String,Object> map);




}
