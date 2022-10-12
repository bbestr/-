package com.qinshuihe1.common.logininterface;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
public class LoginUserVo implements UserDetails, Serializable {
    private static final long serialVersionUID = -5829717301114201114L;
    private Integer id;
    private UserVO uservo;
    private List<String> permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){return null;}
    @Override
    public String getPassword(){
        return uservo.getPassword();
    }
    @Override
    public String getUsername(){
        return uservo.getUsername();
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
}
