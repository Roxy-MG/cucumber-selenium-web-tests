package com.goosying.cucumber.enums;

import lombok.Getter;

@Getter
public enum LoginResult {

    SUCCESS("登录成功"),
    INVALID("用户名或密码不正确"),
    LOCKED("用户被锁定");

    private final String message;

    LoginResult(String message) {
        this.message = message;
    }

    public static LoginResult getByMessage(String message){
        for (LoginResult value : values()) {
            if (value.getMessage().equals(message)){
                return value;
            }
        }
        throw new IllegalArgumentException("未知的登录信息: " + message);
    }

}
