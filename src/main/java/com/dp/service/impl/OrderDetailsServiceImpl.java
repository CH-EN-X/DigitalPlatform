package com.dp.service.impl;

import com.dp.entity.OrderDetails;
import com.dp.mapper.OrderDetailsMapper;
import com.dp.mapper.OrderTableMapper;
import com.dp.service.OrderDetailsService;
import com.dp.util.MybatisPlusUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public ResultVO add(OrderDetails order) {
//        if ("".equals(order.getPId()) || order.getPId() == null ||
//            "".equals(order.getPNumber()) || order.getPNumber() == null){
//            return new ResultVO(ResultEnum.ERROR);
//        }
        SqlSession session = MybatisPlusUtil.getSession();
        orderDetailsMapper = session.getMapper(OrderDetailsMapper.class);
        orderDetailsMapper.insert(order);
        return new ResultVO(ResultEnum.SUCCESS);
    }
}
