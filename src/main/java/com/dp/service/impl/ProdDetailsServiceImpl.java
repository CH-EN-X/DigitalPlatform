package com.dp.service.impl;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import com.dp.mapper.ProdDetailsMapper;
import com.dp.service.IProdDetailsService;
import com.dp.util.MybatisUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdDetailsServiceImpl  implements IProdDetailsService {



    private ProdDetailsMapper mapper;
    @Override
    public Map<String,Object> finds(Map<String,Object> map) {



        if(null!=map && null!=map.get("page") && null != map.get("limit")){
            map.put("page",Integer.parseInt(map.get("page").toString()));
            map.put("limit",Integer.parseInt(map.get("limit").toString()));
        }


        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(ProdDetailsMapper.class);

        List<ProdDetails > list = mapper.finds(map);
        System.out.println(list);
        int total = mapper.total(map);
        //创建HashMap存储数据
        Map<String,Object> m = new HashMap<>();
        if(null == list || list.isEmpty()){
            m.put("code",600);
            m.put("msg","暂无数据");
        }
        else{
            m.put("code",200);
            m.put("msg","成功");
            m.put("data",list);
            m.put("count",total);
        }

        MybatisUtil.close(session);

        return m;
    }

    @Override
    public Map<String, Object> select(Map<String, Object> map) {

        if(null!=map && null!=map.get("page") && null != map.get("limit")){
            map.put("page",Integer.parseInt(map.get("page").toString()));
            map.put("limit",Integer.parseInt(map.get("limit").toString()));
            map.put("pName",map.get("pName").toString());
        }





        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(ProdDetailsMapper.class);

        System.out.println( map.get("content"));

        List<ProdDetails > list = mapper.finds(map);
        System.out.println(list);
        int total = mapper.total(map);
        //创建HashMap存储数据
        Map<String,Object> m = new HashMap<>();
        if(null == list || list.isEmpty()){
            m.put("code",600);
            m.put("msg","暂无数据");
        }
        else{
            m.put("code",200);
            m.put("msg","成功");
            m.put("data",list);
            m.put("count",total);
        }

        MybatisUtil.close(session);

        return m;


/*
        Parameter parameter = new Parameter();
        parameter.setPName((String) map.get("content"));*/
    }

    @Override
    public ResultVO FindBalance(ProdDetails prodDetails) {
        if(prodDetails.getPId() == null){
            return new ResultVO(ResultEnum.DATA_NULL);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ProdDetailsMapper.class);

        prodDetails = mapper.FindBalance(prodDetails);
        return new ResultVO(ResultEnum.SUCCESS,prodDetails);
    }

    @Override
    public ResultVO FindName(ProdDetails prodDetails) {
        if(prodDetails.getPId() == null){
            return new ResultVO(ResultEnum.DATA_NULL);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ProdDetailsMapper.class);

        prodDetails = mapper.FindName(prodDetails);
        return new ResultVO(ResultEnum.SUCCESS,prodDetails);
    }
}
