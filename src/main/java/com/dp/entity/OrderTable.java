package com.dp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrderTable)实体类
 *
 * @author makejava
 * @since 2023-12-13 21:06:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_table")
public class OrderTable implements Serializable {

    @TableId
    private Integer oId;
    
    private Integer aId;
    
    private Integer uId;
    
    private Date rderTime;
    
    private Object totalPrice;
    
    private Date totalTime;
    
    private Integer oState;
    
    private String temp;


}

