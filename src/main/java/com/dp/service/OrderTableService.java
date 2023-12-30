package com.dp.service;

import com.dp.entity.OrderTable;
import com.dp.vo.ResultVO;

public interface OrderTableService {
    ResultVO add(OrderTable order);

    ResultVO finds(OrderTable order);
}
