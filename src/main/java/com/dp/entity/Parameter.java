package com.dp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Parameter)实体类
 *
 * @author makejava
 * @since 2023-12-13 21:06:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("parameter")
public class Parameter implements Serializable {

    @TableId
    private Integer paramId;
    
    private Integer pId;
    
    private String color;
    
    private String memorySize;
    
    private Object price;
    
    private String paramImage;
    
    private String temp;
    private String pName;

    private String tName;


}

