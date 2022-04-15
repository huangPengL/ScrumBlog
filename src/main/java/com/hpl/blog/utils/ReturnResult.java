package com.hpl.blog.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/1 12:59
 */

@Data
public class ReturnResult {
    @ApiModelProperty("是否成功")
    private boolean success;

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    //无参构造方法私有(使得外部只能通过调用ok() 和 error()来获取对象)
    private ReturnResult() { }


    //成功 静态方法
    public static ReturnResult ok(){
        ReturnResult r = new ReturnResult();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功！");
        return r;
    }
    //失败 静态方法
    public static ReturnResult error(){
        ReturnResult r = new ReturnResult();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败！");
        return r;
    }

    // 链式编程
    public ReturnResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ReturnResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public ReturnResult message(String message){
        this.setMessage(message);
        return this;
    }

    public ReturnResult data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public ReturnResult data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

}
