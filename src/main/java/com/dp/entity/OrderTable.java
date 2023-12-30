package com.dp.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dp.common.CharConverter;
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


    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "订单ID")//,converter = CharConverter.class)
    private Integer oId;

    @ExcelProperty(value = "地址ID")//,converter = CharConverter.class)
    private Integer aId;

    @ExcelProperty(value = "用户ID")//converter = CharConverter.class)
    private Integer uId;

    @ExcelProperty(value = "下单时间")
    private String rderTime;

    @ExcelProperty(value = "价格")//converter = CharConverter.class)
    private Float totalPrice;

    @ExcelProperty(value = "目标时间")
    private String totalTime;

    @ExcelProperty(value = "状态")//,converter = CharConverter.class)
    private Integer oState;

    @ExcelIgnore
    private String temp;


}

