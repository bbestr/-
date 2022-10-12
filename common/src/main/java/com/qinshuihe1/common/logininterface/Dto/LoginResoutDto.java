package com.qinshuihe1.common.logininterface.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("登录返回对象")
@Data
public class LoginResoutDto extends BaseDto{

    @ApiModelProperty("认证通过的有效的token")
    private String token;
}
