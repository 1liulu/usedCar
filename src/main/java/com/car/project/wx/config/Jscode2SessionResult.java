package com.car.project.wx.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Jscode2SessionResult implements Serializable {
    private static final long serialVersionUID = -1060216618475607933L;

    @JsonProperty("session_key")
    private String sessionKey;

    @JsonProperty("openid")
    private String openid;

    @JsonProperty("unionid")
    private String unionid;
}
