package com.dp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.Parameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper extends BaseMapper<ParameterMapper> {

    List<Parameter> FindByPid(Integer pid);

    List<Parameter> FindPrice(String memorySize);


    Parameter find(@Param("obj") Parameter parameter);



    Integer add(@Param("obj")Parameter parameter);



    Integer total(@Param("obj") Parameter parameter);

    List<Map<String,Object>> FindPage(@Param("obj") Parameter parameter,
                                      @Param("page")Integer pageNum, @Param("limit")Integer pageSize);

    Integer BackDelete(@Param("obj")Parameter parameter);

    Integer BackUpdatePrice(@Param("obj") Parameter parameter);

}
