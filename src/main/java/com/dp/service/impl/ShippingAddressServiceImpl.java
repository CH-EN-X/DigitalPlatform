package com.dp.service.impl;

import com.dp.entity.ShippingAddress;
import com.dp.mapper.ShippingAddressMapper;
import com.dp.service.IShippingAddressService;
import com.dp.util.MybatisUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ShippingAddressServiceImpl implements IShippingAddressService {

    private ShippingAddressMapper mapper;

    @Override
    public ResultVO addAddress(ShippingAddress shippingAddress) {
        if(shippingAddress.getUId() == null || shippingAddress.getAName() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShippingAddressMapper.class);
        Integer result = mapper.addAddress(shippingAddress);
        session.close();

        return new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO FindAll(ShippingAddress shippingAddress) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShippingAddressMapper.class);
        List<ShippingAddress> list = mapper.FindAll(shippingAddress);

        session.close();
        return new ResultVO(ResultEnum.SUCCESS,list);
    }

    @Override
    public ResultVO UpdateAddress(ShippingAddress shippingAddress) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShippingAddressMapper.class);
        Integer result = mapper.UpdateAddress(shippingAddress);
        session.close();

        if(result < 0){
            return new ResultVO(ResultEnum.ERROR);
        }else{
            return new ResultVO(ResultEnum.SUCCESS,result);
        }
    }

    @Override
    public ResultVO set(ShippingAddress shippingAddress) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShippingAddressMapper.class);
        mapper.setAll();
        Integer result = mapper.set(shippingAddress);
        session.close();

        if(result < 0){
            return new ResultVO(ResultEnum.ERROR);
        }else{
            return new ResultVO(ResultEnum.SUCCESS,result);
        }
    }

    @Override
    public ResultVO delete(ShippingAddress shippingAddress) {
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShippingAddressMapper.class);
        Integer result = mapper.delete(shippingAddress);

        session.close();

        if(result < 0){
            return new ResultVO(ResultEnum.ERROR);
        }else{
            return new ResultVO(ResultEnum.SUCCESS,result);
        }
    }
}
