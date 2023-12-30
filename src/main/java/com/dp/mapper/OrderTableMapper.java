package com.dp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.OrderTable;

import java.util.List;
import java.util.Map;

public interface OrderTableMapper extends BaseMapper<OrderTable> {


    List<Map<String, Object>> selectList(OrderTable orderTable);
}
