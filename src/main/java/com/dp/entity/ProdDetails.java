package com.dp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ProdDetails)实体类
 *
 * @author makejava
 * @since 2023-12-13 21:06:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("prod_details")
public class ProdDetails implements Serializable {

    @TableId
    private Integer pId;
    
    private String pName;
    
    private Integer tId;
    
    private Integer stock;
    
    private String pImage;
    
    private String temp;



}

