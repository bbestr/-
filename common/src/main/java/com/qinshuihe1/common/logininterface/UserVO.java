package com.qinshuihe1.common.logininterface;

import javax.annotation.sql.DataSourceDefinition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="UserVO",description = "用户描述信息")
public class UserVO {

    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;
}
