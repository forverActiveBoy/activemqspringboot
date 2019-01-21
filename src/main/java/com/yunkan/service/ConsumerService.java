package com.yunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.TextMessage;

@Service
public class ConsumerService {
    @JmsListener(destination = "myQueue")
    //此处返回值必须为空，不然的话，老是报错
    public void receive(String message){
        System.out.println(message);
    }
}
