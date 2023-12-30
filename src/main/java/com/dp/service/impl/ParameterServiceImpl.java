package com.dp.service.impl;

import com.dp.entity.Parameter;
import com.dp.mapper.ParameterMapper;
import com.dp.service.IParameterService;
import com.dp.util.MybatisUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterServiceImpl implements IParameterService {

    private ParameterMapper mapper;



    @Override
    public Map<String, Object> FindPage(Parameter parameter, Integer pageNum, Integer pageSize) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ParameterMapper.class);
        List<Map<String, Object>> list = mapper.FindPage(parameter, (pageNum-1)*pageSize, pageSize);

        Integer total = mapper.total(parameter);
        session.close();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",list);
        map.put("count",total);

        if(list == null || list.isEmpty()){
            map.put("msg","暂无数据");
        }else{
            map.put("msg","成功");
        }
        return map;
    }

    @Override
    public ResultVO BackDelete(Parameter parameter) {
        if(parameter.getParamId() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ParameterMapper.class);
        Integer result =  mapper.BackDelete(parameter);
        session.close();
        return new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO BackUpdatePrice(Parameter parameter) {
        if(parameter.getParamId() == null || parameter.getPrice() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ParameterMapper.class);
        Integer result =  mapper.BackUpdatePrice(parameter);
        session.close();
        return new ResultVO(ResultEnum.SUCCESS,result);
    }



    @Override
    public ResultVO doAdd(Parameter parameter) {
        if(parameter.getPId() == null || parameter.getColor() == null || parameter.getMemorySize() == null ||
                parameter.getPrice() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ParameterMapper.class);
        Integer result = mapper.add(parameter);
        session.close();

        if(result < 0 ){
            return new ResultVO(ResultEnum.ERROR);
        }else {
            return new ResultVO(ResultEnum.SUCCESS);
        }
    }
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
