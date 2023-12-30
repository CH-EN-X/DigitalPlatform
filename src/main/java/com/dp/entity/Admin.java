package com.dp.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin")
public class Admin implements Serializable {


    private Integer ano;//编号
    private String aname;//管理员姓名
    private  String apwd;//密码
    private String atel;//手机号
    private String role;//角色 超级管理员  普通管理员
    private String temp;


}
