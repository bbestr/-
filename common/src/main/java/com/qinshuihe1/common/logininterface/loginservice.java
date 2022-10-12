package com.qinshuihe1.common.logininterface;

import com.qinshuihe1.common.logininterface.Dto.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("登录接口")
public interface loginservice {

    @ApiOperation("/admin/login")
    ResultDto<String> login(UserVO uservo);


    @ApiOperation("/admin/login")
    ResultDto<String> logout(UserVO uservo);
}
