package com.dp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.Parameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParameterMapper extends BaseMapper<ParameterMapper> {

    List<Parameter> FindByPid(Integer pid);

    List<Parameter> FindPrice(String memorySize);


    Parameter find(@Param("obj") Parameter parameter);
}
