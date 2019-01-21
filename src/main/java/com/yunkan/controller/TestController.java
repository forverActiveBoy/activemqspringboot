package com.yunkan.controller;

import com.yunkan.service.ConsumerService;
import com.yunkan.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping("/test")
    public @ResponseBody String test(){
        return "hello  ActiveMQ!!!";
    }
    @RequestMapping("/send")
    public @ResponseBody void send(String mes){
        providerService.send(mes);
    }
}
