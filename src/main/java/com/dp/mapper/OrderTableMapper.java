package com.dp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.OrderTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderTableMapper extends BaseMapper<OrderTable> {

    @Select(" select o_id,a_id, u_id,rder_time,total_price,total_time,o_state from Order_Table where u_id = 2")
    List<OrderTable> getOrderTables(Integer id);

    List<Map<String, Object>> selectList(OrderTable orderTable);
}
