package com.dp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (OrderDetails)实体类
 *
 * @author makejava
 * @since 2023-12-13 21:06:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_details")
public class OrderDetails implements Serializable {


    private Integer oId;
    
    private Integer pId;
    
    private Integer pNumber;
    
    private Object oPrice;
    
    private String temp;


}

