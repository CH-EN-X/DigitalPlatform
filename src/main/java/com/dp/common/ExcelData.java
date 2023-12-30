package com.dp.common;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelData {

    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;

    private Integer oId;

    private Integer aId;

    private Integer uId;

    private String rderTime;

    private Object totalPrice;

    private String totalTime;

    private Integer oState;

    private Integer paramId;

    private Integer pNumber;

    private Object oPrice;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}