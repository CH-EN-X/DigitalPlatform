package com.dp.service.impl;

import com.dp.entity.Parameter;
import com.dp.entity.ProdDetails;
import com.dp.mapper.ProdDetailsMapper;
import com.dp.mapper.ProdTypeMapper;
import com.dp.service.IProdTypeService;
import com.dp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdTypeServiceImpl  implements IProdTypeService {


    private ProdTypeMapper mapper;


    @Override
    public Map<String, Object> finds(Map<String, Object> map) {



        System.out.println(map);
        if(null!=map && null!=map.get("page") && null != map.get("limit") && null!=map.get("type") ){
            map.put("page",Integer.parseInt(map.get("page").toString()));
            map.put("limit",Integer.parseInt(map.get("limit").toString()));
            map.put("type",map.get("type").toString());
        }


        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(ProdTypeMapper.class);




        List<ProdDetails> list = mapper.finds(map);
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



}
