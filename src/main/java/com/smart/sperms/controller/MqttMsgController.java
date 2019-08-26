package com.smart.sperms.controller;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.config.PropertiesConfig;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.MqttPayloadReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.service.MqttSendService;
import com.smart.sperms.utils.XxteaUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "mqtt-msg", description = "MQTT消息请求")
@RestController
@RequestMapping(value = "mqtt")
public class MqttMsgController {

    private static Logger logger = LoggerFactory.getLogger(MqttMsgController.class);

    @Autowired
    MqttSendService mqttSendService;

    @Autowired
    PropertiesConfig propertiesConfig;

    @ApiOperation(value = "发送消息--默认主题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "消息内容", required = true, paramType = "form")
    })
    @PostMapping(value="/send_msg")
    public CommonWrapper sendMsg(@RequestParam String message){
        CommonWrapper wrapper = new CommonWrapper();
        mqttSendService.sendToMqtt("defualt-topic:"+message);
        return wrapper;
    }

    @ApiOperation(value = "发送消息--指定主题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic", value = "消息主题", required = true, paramType = "form"),
            @ApiImplicitParam(name = "message", value = "消息内容", required = true, paramType = "form")
    })
    @PostMapping(value="/send_msg_by_topic")
    public CommonWrapper sendMsgByTopic(@RequestParam String topic, @RequestParam String message){
        CommonWrapper wrapper = new CommonWrapper();
        String key = propertiesConfig.getXxtea_key_smart();
        try {
            String payload = XxteaUtils.encryptToHexString(message, key);
            mqttSendService.sendToMqtt(topic, payload);
            logger.debug("mqtt send msg...topic = {}, message = {}", topic, payload);
        } catch (Exception e) {
            logger.error("mqtt send msg error...topic = "+ topic +", message = "+ message, e);
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            wrapper.setResultMsg("发送MQTT消息异常");
        }

        return wrapper;
    }

    @ApiOperation(value = "发送Payload消息--指定主题")
    @PostMapping(value="/send_payload_by_topic")
    public CommonWrapper sendPayloadByTopic(@RequestBody MqttPayloadReq req){
        CommonWrapper wrapper = new CommonWrapper();
        String key = propertiesConfig.getXxtea_key_smart();
        String topic = req.getTopic();
        MsgPayload payload = req.getPayload();
        String message = JSON.toJSONString(payload);
        try {
            String data = req.isEncrypt()? XxteaUtils.encryptToHexString(message, key) : message;
            mqttSendService.sendToMqtt(topic, data);
            logger.debug("mqtt send msg...topic = {}, message = {}", topic, payload);
        } catch (Exception e) {
            logger.error("mqtt send msg error...topic = "+ topic +", message = "+ message, e);
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            wrapper.setResultMsg("发送MQTT消息异常");
        }

        return wrapper;
    }
}