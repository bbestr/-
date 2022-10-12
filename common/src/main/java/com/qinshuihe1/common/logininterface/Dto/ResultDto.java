package com.qinshuihe1.common.logininterface.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("返回的结果集")
public class ResultDto<T> extends BaseDto{

    @ApiModelProperty("返回的业务数据")
    private T obj;
}
