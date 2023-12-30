package com.dp.service.impl;

import com.dp.entity.ShoppingCart;
import com.dp.mapper.ShoppingCartMapper;
import com.dp.service.IShoppingCartService;
import com.dp.util.MybatisPlusUtil;
import com.dp.util.MybatisUtil;
import com.dp.util.ResultEnum;
import com.dp.vo.ResultVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ShoppingCartServiceImpl implements IShoppingCartService {

    private ShoppingCartMapper mapper;

    @Override
    public ResultVO addCart(ShoppingCart shoppingCart) {
        if(shoppingCart.getUId() == null || shoppingCart.getParamId() == null || shoppingCart.getCNumber() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShoppingCartMapper.class);

        //如果已经添加购物车，就数量加1
        ShoppingCart shoppingCart1 = mapper.find(shoppingCart);
        if(shoppingCart1 != null){
            Integer integer = mapper.updateNum(shoppingCart1,1);
            session.close();
            return new ResultVO(ResultEnum.SUCCESS,integer);
        }else{
            //没有就添加购物车
            int result = mapper.add(shoppingCart);
            session.close();
            return new ResultVO(ResultEnum.SUCCESS,result);
        }

    }

    @Override
    public ResultVO selectCart(Integer cId) {
        if("".equals(cId) || cId == null){
            return new ResultVO(ResultEnum.ERROR);
        }

        SqlSession session = MybatisPlusUtil.getSession();
        mapper = session.getMapper(ShoppingCartMapper.class);

        Map<String,Object> cart = mapper.selectCart(cId);

        return new ResultVO(ResultEnum.SUCCESS,cart);
    }


    @Override
    public ResultVO finds(String uid) {
        if("".equals(uid) || uid == null){
            return new ResultVO(ResultEnum.ERROR);
        }

        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShoppingCartMapper.class);
        List<Map<String, Object>> list = mapper.finds(uid);
        session.close();

        if(list == null || list.isEmpty()){
            return new ResultVO(ResultEnum.DATA_NULL);
        }

        return new ResultVO(ResultEnum.SUCCESS,list);
    }

    @Override
    public ResultVO increase(ShoppingCart shoppingCart) {
        if(shoppingCart.getCId() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShoppingCartMapper.class);
        Integer result = mapper.updateNum(shoppingCart,1);
        return new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO reduce(ShoppingCart shoppingCart) {
        if(shoppingCart.getCId() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShoppingCartMapper.class);
        Integer result = mapper.updateNum(shoppingCart,-1);
        return new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO remove(ShoppingCart shoppingCart) {
        if(shoppingCart.getCId() == null){
            return new ResultVO(ResultEnum.ERROR);
        }
        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShoppingCartMapper.class);
        Integer result = mapper.remove(shoppingCart);
        return  new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO selected(ShoppingCart shoppingCart) {
        if(shoppingCart.getCId()  == null){
            return new ResultVO(ResultEnum.ERROR);
        }

        SqlSession session = MybatisUtil.getSession(true);
        mapper = session.getMapper(ShoppingCartMapper.class);

        Map<String, Object> selected = mapper.selected(shoppingCart);
        return new ResultVO(ResultEnum.SUCCESS,selected);
    }
}
