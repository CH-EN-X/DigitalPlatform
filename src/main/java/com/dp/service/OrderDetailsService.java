package com.dp.service;

import com.dp.entity.OrderDetails;
import com.dp.vo.ResultVO;

public interface OrderDetailsService {
    ResultVO add(OrderDetails order);
}
