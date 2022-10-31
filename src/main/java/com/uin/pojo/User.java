package com.uin.pojo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/11/7:25 PM
 */
public class User implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;//授权的

    private JSONObject params;

    public JSONObject getParams() {
        return params;
    }

    public void setParams(JSONObject params) {
        this.params = params;
    }

    public User(JSONObject params){
        super();
        this.params = params;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.params.getString("password");
    }

    @Override
    public String getUsername() {
        return this.params.getString("username");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
