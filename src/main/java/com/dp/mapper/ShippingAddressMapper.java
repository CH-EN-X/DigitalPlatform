package com.dp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.ShippingAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingAddressMapper extends BaseMapper<ShippingAddress> {

    Integer addAddress(@Param("obj")ShippingAddress shippingAddress);

    List<ShippingAddress> FindAll(@Param("obj") ShippingAddress shippingAddress);

    Integer UpdateAddress(@Param("obj") ShippingAddress shippingAddress);

    void setAll();

    Integer set(@Param("obj") ShippingAddress shippingAddress);

    Integer delete(@Param("obj") ShippingAddress shippingAddress);
}
