package com.dp.service;

import com.dp.entity.ShoppingCart;
import com.dp.vo.ResultVO;

public interface IShoppingCartService {

    ResultVO selectCart(Integer cId);

    ResultVO addCart(ShoppingCart shoppingCart);



    ResultVO finds(String uid);

    ResultVO increase(ShoppingCart shoppingCart);

    ResultVO reduce(ShoppingCart shoppingCart);

    ResultVO remove(ShoppingCart shoppingCart);

    ResultVO selected(ShoppingCart shoppingCart);

}
