package com.dp.service;

import com.dp.entity.ShippingAddress;
import com.dp.vo.ResultVO;

public interface IShippingAddressService {

    ResultVO addAddress(ShippingAddress shippingAddress);

    ResultVO FindAll(ShippingAddress shippingAddress);

    ResultVO UpdateAddress(ShippingAddress shippingAddress);

    ResultVO set(ShippingAddress shippingAddress);

    ResultVO delete(ShippingAddress shippingAddress);
}
