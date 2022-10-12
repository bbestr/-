package com.qinshuihe1.common.login;

import com.qinshuihe1.common.logininterface.Dto.ResultDto;
import com.qinshuihe1.common.logininterface.UserVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qinshuihe1.common.logininterface.loginservice;

@RequestMapping("/admin")
@RestController
public class logincontroller implements loginservice{


    @Override
    @GetMapping("/login")
    public ResultDto<String> login(UserVO uservo){
        ResultDto<String> resuledto = new ResultDto<>();
        resuledto.setObj("username"+uservo.getUsername()+"password"+uservo.getPassword());
        return resuledto;
    }

    @Override
    @GetMapping("/logout")
    public ResultDto<String> logout(UserVO uservo){
        ResultDto<String> resuledto = new ResultDto<>();
        return resuledto;
    }
}
