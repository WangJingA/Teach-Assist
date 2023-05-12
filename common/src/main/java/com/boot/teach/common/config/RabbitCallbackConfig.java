package com.boot.teach.common.config;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitma消息回调
 * @author : hzx
 * @date : 2023/5/12
 */
@Configuration
public class RabbitCallbackConfig {
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //只有开启此配置才能触发消息回调
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("confirmCallBack ...相关数据："+correlationData);
                System.out.println("confirmCallBack ...相关信息:"+ack);
                System.out.println("confirmCallBack ...相关原因："+cause);
            }
        });

        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback:     "+"消息："+message);
                System.out.println("ReturnCallback:     "+"回应码："+replyCode);
                System.out.println("ReturnCallback:     "+"回应信息："+replyText);
                System.out.println("ReturnCallback:     "+"交换机："+exchange);
                System.out.println("ReturnCallback:     "+"路由键："+routingKey);
            }

            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("returnedMessage:"+returnedMessage);
            }

            @Override
            public RabbitTemplate.ReturnCallback delegate() {
                return RabbitTemplate.ReturnsCallback.super.delegate();
            }
        });

        return rabbitTemplate;
    }
}
