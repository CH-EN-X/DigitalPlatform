package com.dp.vo;


import com.dp.util.ResultEnum;

/**
 * 结果视图对象
 */
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultVO(ResultEnum enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public ResultVO(ResultEnum enums, Object data) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.data = data;
    }

    public ResultVO(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
