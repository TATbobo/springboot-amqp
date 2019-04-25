package com.tucker.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.HashMap;

@Service
public class BookService {

    @RabbitListener(queues = "tucker.news")
    public void  receive(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
