package com.smart.sperms.request;

import com.smart.sperms.api.protocol.MsgPayload;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * MQTT消息
 */
@ApiModel(description = "MQTT消息体")
public class MqttPayloadReq implements Serializable {

    @ApiModelProperty(value = "主题")
    private String topic;

    @ApiModelProperty(value = "消息体")
    private MsgPayload payload;

    @ApiModelProperty(value = "是否需要数据加密")
    private boolean isEncrypt;

    @ApiModelProperty(value = "密钥")
    private String xxteaKey;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public MsgPayload getPayload() {
        return payload;
    }

    public void setPayload(MsgPayload payload) {
        this.payload = payload;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setEncrypt(boolean encrypt) {
        isEncrypt = encrypt;
    }

    public String getXxteaKey() {
        return xxteaKey;
    }

    public void setXxteaKey(String xxteaKey) {
        this.xxteaKey = xxteaKey;
    }
}
