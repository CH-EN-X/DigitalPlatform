package com.dp.service.impl;

import com.dp.entity.Admin;
import com.dp.entity.ProdDetails;
import com.dp.mapper.AdminMapper;
import com.dp.mapper.ParameterMapper;
import com.dp.mapper.ProdDetailsMapper;
import com.dp.service.IAdminService;
import com.dp.util.MybatisUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements IAdminService {


    private AdminMapper mapper;
    @Override
    public ResultVO add(Admin admin) {
        if(admin.getAname() == null || admin.getAtel() == null || admin.getRole() == null ){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(AdminMapper.class);
        Integer result = mapper.add(admin);
        session.close();

        if(result < 0 ){
            return new ResultVO(ResultEnum.ERROR);
        }else {
            return new ResultVO(ResultEnum.SUCCESS);
        }
    }


    @Override
    public Map<String, Object> findPage(Map<String, Object> map) {


        if(null!=map && null!=map.get("page") && null != map.get("limit")){
            map.put("page",Integer.parseInt(map.get("page").toString()));
            map.put("limit",Integer.parseInt(map.get("limit").toString()));
        }


        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(AdminMapper.class);

        List<Admin> list = mapper.findPage(map);
        System.out.println(list);
        int total = mapper.total(map);
        //创建HashMap存储数据
        Map<String,Object> m = new HashMap<>();
        if(null == list || list.isEmpty()){
            m.put("code",600);
            m.put("msg","暂无数据");
        }
        else{
            m.put("code",0);
            m.put("msg","成功");
            m.put("data",list);
            m.put("count",total);
        }

        MybatisUtil.close(session);

        return m;
    }

    @Override
    public int delete(Map<String, Object> map) {

        map.put("ano",Integer.parseInt(map.get("ano").toString()));
        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(AdminMapper.class);

        int x = mapper.shanchu(map);
        return x;

    }

    @Override
    public int adminlogin(Map<String, Object> map) {

        map.put("atel",map.get("atel").toString());
        map.put("apwd",map.get("apwd").toString());

        SqlSession session = MybatisUtil.getSession( true);
        mapper = session.getMapper(AdminMapper.class);

        int list = mapper.adminlogin(map);



        MybatisUtil.close(session);

        return list;
    }


}
