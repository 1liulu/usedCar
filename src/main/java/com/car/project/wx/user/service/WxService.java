package com.car.project.wx.user.service;

import com.car.common.entity.BaseResponse;
import com.car.common.enums.StatusCodeEnum;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.http.HttpUtils;
import com.car.framework.config.WxConfig;
import com.car.project.wx.config.Jscode2SessionResult;
import com.car.project.wx.config.WxTools;
import com.car.project.wx.user.domain.WxUserRequest;
import com.car.project.wx.user.mapper.WxUserMapper;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxService extends WxTools {

    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private WxUserMapper userMapper;

    public WxUserRequest login(String code) {
        Map<String, String> param = new HashMap<>();
        param.put("appid", wxConfig.getAppid());
        param.put("secret", wxConfig.getSecret());
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String urlParam = "appid=" + wxConfig.getAppid() + "&secret=" + wxConfig.getSecret() + "&js_code=" + code + "&grant_type=authorization_code";

        String result = HttpUtils.sendGet(JSCODE_TO_SESSION_URL, urlParam);
        System.out.println(result);
        Jscode2SessionResult jscode2SessionResult = JsonUtils.toObject(result, Jscode2SessionResult.class);

        WxUserRequest userRequest = userMapper.selectByOpenid(jscode2SessionResult.getOpenid());
        if (userRequest == null) {
            userMapper.insertByOpneid(jscode2SessionResult.getOpenid());
            userRequest = userMapper.selectByOpenid(jscode2SessionResult.getOpenid());
        }
        return userRequest;

    }

    public void wcatLogin(HttpServletRequest request, HttpServletResponse response, String requestURL) {
        try {
            String backUrl = "/users/wx/callBack";
            String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +
                    "&redirect_uri=" + URLEncoder.encode(backUrl, "UTF-8") +
                    "&response_type=code" +
                    "&scope=snsapi_userinfo" +
                    "&state=" + requestURL;
            response.sendRedirect(requestUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public BaseResponse buid(WxUserRequest request) {

        if (userMapper.updateByUser(request) > 0) {
            return BaseResponse.of(StatusCodeEnum.SUCCESS, "修改成功", request);
        }
        return BaseResponse.error("修改失败");
    }

    public BaseResponse user(WxUserRequest request) {

        return BaseResponse.of(userMapper.selectByUserId(request.getUserId()));
    }
}
