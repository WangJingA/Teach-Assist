package com.boot.teach.common.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * Channel
 * Message Listener
 */
@Component
public class MyAckReceiver implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            byte[] body = message.getBody();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(body));
            Map<String, String> readObject = (Map<String, String>) objectInputStream.readObject();
            String messageId = readObject.get("messageId");
            String messageData = readObject.get("messageData");
            String createTime = readObject.get("createTime");
            objectInputStream.close();
            System.out.println("  MyAckReceiver  messageId:" + messageId + "  messageData:" + messageData + "  createTime:" + createTime);
            System.out.println("消费的主题消息来自：" + message.getMessageProperties().getConsumerQueue());
            //设置消息确认，true手动确认，false->默认确认
            channel.basicAck(deliveryTag, true);
        }catch (Exception e){
            e.printStackTrace();
            channel.basicAck(deliveryTag,false);
        }
    }
}
