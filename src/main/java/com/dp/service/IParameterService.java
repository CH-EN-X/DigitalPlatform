package com.dp.service;

import com.dp.entity.Parameter;
import com.dp.vo.ResultVO;

import java.util.Map;

public interface IParameterService {



    ResultVO doAdd(Parameter parameter);


    ResultVO find(Parameter parameter);


    ResultVO FindByPid(Parameter parameter);

    ResultVO FindPrice(Parameter parameter);

    Map<String, Object> FindPage(Parameter parameter, Integer pageNum, Integer pageSize);

    ResultVO BackDelete(Parameter parameter);

    ResultVO BackUpdatePrice(Parameter parameter);




}
