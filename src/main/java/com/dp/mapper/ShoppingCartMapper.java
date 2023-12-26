package com.dp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dp.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    ShoppingCart selectCart(@Param("cID") Integer cId);

    Integer add(@Param("obj") ShoppingCart shoppingCart);



    List<Map<String,Object>> finds(@Param("uId")String uId);

    ShoppingCart find(@Param("obj")ShoppingCart shoppingCart);

    Integer updateNum(@Param("obj")ShoppingCart shoppingCart,@Param("num") Integer num);

    Integer remove(@Param("obj")ShoppingCart shoppingCart);

    Map<String,Object> selected(@Param("obj")ShoppingCart shoppingCart);

}
