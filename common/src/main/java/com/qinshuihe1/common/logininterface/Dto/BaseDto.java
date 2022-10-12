package com.qinshuihe1.common.logininterface.Dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "请求返回基本信息")
public class BaseDto {

    /*
    状态码
     */
    @ApiModelProperty("返回状态码")
    private int code = 200;
    /*
    返回信息
     */
    @ApiModelProperty("返回信息")
    private String messge = "成功";
}
