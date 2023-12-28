package com.dp.service.impl;

import com.dp.entity.OrderTable;
import com.dp.mapper.OrderDetailsMapper;
import com.dp.mapper.OrderTableMapper;
import com.dp.service.OrderTableService;
import com.dp.util.MybatisPlusUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderTableServiceImpl implements OrderTableService {

    @Autowired
    private OrderTableMapper orderTableMapper;


    @Override
    public ResultVO add(OrderTable order) {
//        //地址和用户id不能为空
//        if ("".equals(order.getAId()) || order.getAId() == null ||
//            "".equals(order.getUId()) || order.getUId() == null){
//            return new ResultVO(ResultEnum.ERROR);
//        }
        SqlSession session = MybatisPlusUtil.getSession();
        orderTableMapper = session.getMapper(OrderTableMapper.class);

        // 获取当前时间
        SimpleDateFormat formatter = new SimpleDateFormat();// 格式化时间
        formatter.applyPattern("yyyy-MM-dd HH:mm:ss ");// a为am/pm的标记
        Date date = new Date();
        System.out.println("现在时间：" + formatter.format(date));

        order.setRderTime(formatter.format(date));
        order.setTotalTime(formatter.format(date));
        orderTableMapper.insert(order);
        return new ResultVO(ResultEnum.SUCCESS);
    }

    @Override
    public ResultVO finds(OrderTable order) {
        SqlSession session = MybatisPlusUtil.getSession();
        orderTableMapper = session.getMapper(OrderTableMapper.class);
        List<Map<String,Object>> list = orderTableMapper.selectList(order);
        return new ResultVO(ResultEnum.SUCCESS,list);
    }
}
