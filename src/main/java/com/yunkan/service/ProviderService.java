package com.yunkan.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service
public class ProviderService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(final String mes){
        //接口有实现类则，new实现类，没有实现类，则用匿名内部类来new对象
        MessageCreator messageCreator = new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(mes);
                return textMessage;
            }
        };
        //指定目的地
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("myQueue");
        jmsTemplate.send(activeMQQueue,messageCreator);
    }
}
