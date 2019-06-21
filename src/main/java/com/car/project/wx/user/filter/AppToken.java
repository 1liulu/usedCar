package com.car.project.wx.user.filter;

import org.apache.shiro.authc.AuthenticationToken;

public class AppToken implements AuthenticationToken {

    // 密钥
    private String token;

    public AppToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

