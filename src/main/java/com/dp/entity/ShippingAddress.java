package com.dp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ShippingAddress)实体类
 *
 * @author makejava
 * @since 2023-12-13 21:06:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shipping_address")
public class ShippingAddress implements Serializable {

    @TableId
    private Integer aId;
    
    private Integer uId;
    
    private String aName;
    
    private String accieveName;
    
    private String accievePhone;
    
    private Integer status;
    
    private String temp;



}

