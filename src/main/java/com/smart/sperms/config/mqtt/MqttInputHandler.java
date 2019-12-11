package com.smart.sperms.config.mqtt;

import com.smart.sperms.api.protocol.MsgDecoder;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
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
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Configuration
@IntegrationComponentScan
public class MqttInputHandler {

    private static final Logger logger = LoggerFactory.getLogger(MqttInputHandler.class);

    @Autowired
    private MqttConfig mqttConfig;

    @Autowired
    private EquipmentDao equipmentDao;

    private MqttPahoMessageDrivenChannelAdapter adapter;

    //接收通道
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    //配置client,监听的topic
    @Bean
    public MessageProducer inbound() {
        Equipment condition = new Equipment();
        List<Equipment> equipList = equipmentDao.queryList(condition);

        List<String> topicList = new ArrayList<>();
        topicList.add(mqttConfig.getDefaultTopic());

        String TOPIC_PREFIX_ANDROID = mqttConfig.getTopic_smart_android();
//        String TOPIC_PREFIX_ANDROID = mqttConfig.getTopic_smart_web();

        if(!CollectionUtils.isEmpty(equipList)) {
            for(Equipment equipment:equipList) {
                String topic = TOPIC_PREFIX_ANDROID + equipment.geteId();
                topicList.add(topic);
            }
        }
//        topicList.add("/machine_web/1001");
        String[] topics = new String[topicList.size()];
        topicList.toArray(topics);

        adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqttConfig.getClientId()+"_inbound", mqttConfig.mqttClientFactory(),
                        topics);
        adapter.setCompletionTimeout(mqttConfig.getCompletionTimeout());
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    /**
     * 增加消息订阅
     * @param eId
     */
    public void addListenTopic(String eId) {
        if(adapter == null) {
            adapter = new MqttPahoMessageDrivenChannelAdapter(mqttConfig.getClientId()+"_inbound", mqttConfig.mqttClientFactory(),
                    "");
        }
        String TOPIC_PREFIX_ANDROID = mqttConfig.getTopic_smart_android();
        String topic = TOPIC_PREFIX_ANDROID + eId;
        adapter.addTopic(topic);
    }

    /**
     * 移除消息订阅
     * @param eId
     */
    public void removeListenTopic(String eId) {
        if(adapter == null) {
            adapter = new MqttPahoMessageDrivenChannelAdapter(mqttConfig.getClientId()+"_inbound", mqttConfig.mqttClientFactory(),
                    "");
        }
        String TOPIC_PREFIX_ANDROID = mqttConfig.getTopic_smart_android();
        String topic = TOPIC_PREFIX_ANDROID + eId;
        adapter.removeTopic(topic);
    }

    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
                String payload = (String)message.getPayload();
                logger.info("recive mqtt msg...topic ={}, payload ={}", topic, payload);

                MsgDecoder.decode(topic, payload);
            }
        };
    }

}
