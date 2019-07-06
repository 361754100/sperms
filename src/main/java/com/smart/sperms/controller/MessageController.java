package com.smart.sperms.controller;

import com.smart.sperms.service.MqttSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "MQTT接口相关api")
@RestController
public class MessageController {

    @Autowired
    MqttSendService mqttSendService;

    @ApiOperation(value = "发送消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "登录账号", required = true, paramType = "form")
    })
    @PostMapping(value="/sendMsg")
    public String sendMsg(@RequestParam String message){

        mqttSendService.sendToMqtt("defualt-topic:"+message);
        return "success";
    }
}