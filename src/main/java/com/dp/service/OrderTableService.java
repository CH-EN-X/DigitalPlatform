package com.dp.service;

import com.dp.entity.OrderTable;
import com.dp.vo.ResultVO;

import java.util.List;
import java.util.Map;

public interface OrderTableService {
    ResultVO add(OrderTable order);

    ResultVO finds(OrderTable order);

    List<OrderTable> getOrderTable(OrderTable  order);
}
