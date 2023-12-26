package com.dp.service;

import com.dp.entity.Parameter;
import com.dp.vo.ResultVO;

public interface IParameterService {






    ResultVO find(Parameter parameter);


    ResultVO FindByPid(Parameter parameter);

    ResultVO FindPrice(Parameter parameter);
}
