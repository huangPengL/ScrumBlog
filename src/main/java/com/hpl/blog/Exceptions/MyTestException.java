package com.hpl.blog.Exceptions;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/3 15:36
 */

@Data
@AllArgsConstructor     // 有参构造
@NoArgsConstructor      // 无参构造
public class MyTestException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private int code;
    private String msg;
}
