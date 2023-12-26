package com.dp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ShoppingCart)实体类
 *
 * @author makejava
 * @since 2023-12-13 21:06:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shopping_cart")
public class ShoppingCart implements Serializable {

    @TableId
    private Integer cId;
    
    private Integer uId;
    
    private Integer paramId;
    
    private Integer cNumber;
    
    private String temp;



}

