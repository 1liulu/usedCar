package com.car.project.wx.user.controller;

import com.car.common.core.controller.BaseController;
import com.car.common.entity.BaseResponse;
import com.car.common.utils.StringUtils;
import com.car.project.wx.user.domain.WxUserRequest;
import com.car.project.wx.user.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WxController extends BaseController {

    @Autowired
    private WxService wxService;

    /**
     * 小程序登录（微信）
     * @param code
     * @return
     */
    @RequestMapping("/login")
//    @ResponseBody
    public BaseResponse login(@RequestParam String code) throws Exception {
        return BaseResponse.of(wxService.login(code));
    }

    @RequestMapping(value = "/H5/index")
    public void wxLogin(String requestURL) throws Exception{
        if(requestURL == null){
            requestURL = "";
        }
        wxService.wcatLogin(request, response, requestURL);
    }


    /**
     * 小程序登录（微信）
     * @param request
     * @return
     */
    @RequestMapping("/buid")
    @ResponseBody
    public BaseResponse buid(WxUserRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getUserId())){
            BaseResponse.error("用户id不能为空");
        }
        if (StringUtils.isEmpty(request.getOpenid())){
            BaseResponse.error("openid不能为空");
        }
        return wxService.buid(request);
    }


    /**
     * 小程序登录（微信）
     * @param request
     * @return
     */
    @RequestMapping("/user")
    @ResponseBody
    public BaseResponse user(WxUserRequest request) throws Exception {
        return wxService.user(request);
    }





}
