package com.qinshuihe1.common.domain.service;

import com.qinshuihe1.common.logininterface.Dto.BaseDto;
import com.qinshuihe1.common.logininterface.Dto.LoginResoutDto;
import com.qinshuihe1.common.logininterface.UserVO;

public interface UserBusService {

    LoginResoutDto login(UserVO uservo);

    BaseDto logout(UserVO uservo);
}
