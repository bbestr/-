package com.qinshuihe1.common.domain.service.Impl;

import com.qinshuihe1.common.domain.service.UserBusService;
import com.qinshuihe1.common.logininterface.Dto.BaseDto;
import com.qinshuihe1.common.logininterface.Dto.LoginResoutDto;
import com.qinshuihe1.common.logininterface.LoginUserVo;
import com.qinshuihe1.common.logininterface.UserVO;
import com.qinshuihe1.common.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserBusServiceImpl implements UserBusService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public LoginResoutDto login(UserVO uservo){
        LoginResoutDto loginResoutDto = new LoginResoutDto();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(uservo.getUsername(),uservo.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if(null ==authentication ){
            throw new RuntimeException("认证失败");
        }
        LoginUserVo loginUserVo = (LoginUserVo) authentication.getPrincipal();
        String username = loginUserVo.getUsername();
        //用登录账号获取token，吧token传到请求方，作为下次访问的凭证
        //loginUserVo 存到分布式缓存中，作为
        String token = JWTUtil.createJWT(username);
        loginResoutDto.setToken(token);
        return loginResoutDto;
    }
    @Override
    public BaseDto logout(UserVO uservo){

        return null;
    }
}
