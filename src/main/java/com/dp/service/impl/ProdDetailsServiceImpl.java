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


        SqlSession session1 = MybatisUtil.getSession( true);
        mapper = session1.getMapper(ProdDetailsMapper.class);

        int total = mapper.ttal(map);
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
        MybatisUtil.close(session1);

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

        int total = mapper.ttal(map);
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
    public Map<String, Object> FindPage(ProdDetails prodDetails, Integer pageNum, Integer pageSize) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ProdDetailsMapper.class);
        List<Map<String, Object>> list = mapper.FindPage(prodDetails, (pageNum-1)*pageSize, pageSize);

        Integer total = mapper.total(prodDetails);
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
    public ResultVO BackDelete(ProdDetails prodDetails) {
        if(prodDetails.getPId()  == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ProdDetailsMapper.class);
        Integer result = mapper.BackDelete(prodDetails);
        session.close();
        return new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO BackUpdateStock(ProdDetails prodDetails) {
        if (prodDetails.getStock() == null || prodDetails.getPId() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ProdDetailsMapper.class);
        Integer result = mapper.BackUpdateStock(prodDetails);
        session.close();
        return new ResultVO(ResultEnum.SUCCESS,result);
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

    @Override
    public ResultVO addGood(ProdDetails prodDetails) {
        if(prodDetails.getPName() == null || prodDetails.getTId() == null || prodDetails.getStock() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ProdDetailsMapper.class);
        Integer result = mapper.addGood(prodDetails);
        session.close();
        return new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO FindAll() {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ProdDetailsMapper.class);
        List<ProdDetails> list = mapper.FindAll();
        session.close();
        if(list == null || list.isEmpty()){
            return  new ResultVO(ResultEnum.DATA_NULL);
        }else{
            return new ResultVO(ResultEnum.SUCCESS,list);
        }
    }

    @Override
    public int update(Map<String, Object> map) {

            map.put("pId",Integer.parseInt(map.get("pId").toString()));



        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(ProdDetailsMapper.class);

        int list = mapper.update(map);



        MybatisUtil.close(session);

        return list;
    }

    @Override
    public Map<String, Object> recommend(Map<String, Object> map) {


        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(ProdDetailsMapper.class);



        List<ProdDetails > list = mapper.recommend(map);


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

        }

        MybatisUtil.close(session);

        return m;
    }
}
