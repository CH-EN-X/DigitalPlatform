package com.dp.service.impl;

import com.dp.entity.Mark;
import com.dp.entity.ProdDetails;
import com.dp.mapper.MarkMapper;
import com.dp.mapper.ProdDetailsMapper;
import com.dp.mapper.UserMapper;
import com.dp.service.IMarkService;
import com.dp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkServiceImpl implements IMarkService {


    private MarkMapper mapper;
    @Override
    public int insert(Mark mark) {


        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(MarkMapper.class);

        int x = mapper.insert(mark);
        System.out.println(x);

        return x;

    }

    @Override
    public Map<String, Object> finds(Map<String, Object> map) {




        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(MarkMapper.class);

        List<Mark> list = mapper.finds(map);
        System.out.println(list);

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

    @Override
    public Map<String, Object> find(Map<String, Object> map) {


        map.put("pId",Integer.parseInt(map.get("pId").toString()));

        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(MarkMapper.class);

        List<ProdDetails> list = mapper.find(map);
        System.out.println(list);

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
