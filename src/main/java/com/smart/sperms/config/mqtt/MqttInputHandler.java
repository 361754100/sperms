package com.smart.sperms.config.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
@IntegrationComponentScan
public class MqttInputHandler {

    private static final Logger logger = LoggerFactory.getLogger(MqttInputHandler.class);

    @Autowired
    private MqttConfig mqttConfig;

    //接收通道
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    //配置client,监听的topic
    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
//                new MqttPahoMessageDrivenChannelAdapter(clientId+"_inbound", mqttClientFactory(),
//                        "hello","hello1");
                new MqttPahoMessageDrivenChannelAdapter(mqttConfig.getClientId()+"_inbound", mqttConfig.mqttClientFactory(),
                        mqttConfig.getDefaultTopic());
        adapter.setCompletionTimeout(mqttConfig.getCompletionTimeout());
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
//                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
//                String type = topic.substring(topic.lastIndexOf("/")+1, topic.length());
//                if("hello".equalsIgnoreCase(topic)){
//                    System.out.println("hello,...,"+message.getPayload().toString());
//                }else if("hello1".equalsIgnoreCase(topic)){
//                    System.out.println("hello1,...,"+message.getPayload().toString());
//                }
                logger.info("收到消息："+(String) message.getPayload());
            }
        };
    }

}
