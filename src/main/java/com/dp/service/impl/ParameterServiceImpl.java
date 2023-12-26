package com.dp.service.impl;

import com.dp.entity.Parameter;
import com.dp.mapper.ParameterMapper;
import com.dp.service.IParameterService;
import com.dp.util.MybatisUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ParameterServiceImpl implements IParameterService {

    private ParameterMapper mapper;


    @Override
    public ResultVO find(Parameter parameter) {
        if(parameter.getMemorySize() == null || parameter.getColor() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ParameterMapper.class);


        parameter = mapper.find(parameter);

        session.close();
        return new ResultVO(ResultEnum.SUCCESS,parameter.getParamId());
    }
    @Override
    public ResultVO FindByPid(Parameter parameter) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ParameterMapper.class);
        List<Parameter> list = null;

        if(parameter.getPId() != null){
             list = mapper.FindByPid(parameter.getPId());
            session.close();
            return new ResultVO(ResultEnum.SUCCESS,list);
        }else{
            return new ResultVO(ResultEnum.DATA_NULL);
        }
    }

    @Override
    public ResultVO FindPrice(Parameter parameter) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ParameterMapper.class);
        List<Parameter> list = null;



        if(parameter.getMemorySize() != null){
            list = mapper.FindPrice(parameter.getMemorySize());
            session.close();
            return new ResultVO(ResultEnum.SUCCESS,list);
        }else {
            return new ResultVO(ResultEnum.DATA_NULL);
        }

    }
}
