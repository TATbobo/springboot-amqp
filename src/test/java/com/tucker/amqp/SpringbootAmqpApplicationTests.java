package com.tucker.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void creatExchange(){
        amqpAdmin.declareExchange(new DirectExchange("test.exchange"));
        System.out.println("创建完成");
        amqpAdmin.declareQueue(new Queue("test.queue",true));
        amqpAdmin.declareBinding(new Binding("test.queue",Binding.DestinationType.QUEUE,"test.exchange","test.haha",null));
    }
    @Test
    public void contextLoads() {
        /*rabbitTemplate.send();*/
        Map<String,Object> map=new HashMap();
        map.put("msg01","第一个消息");
        map.put("msg02","第二个消息");

        rabbitTemplate.convertAndSend("exchange.direct","tucker.news",map);
    }

    /*@Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("tucker.news");
        System.out.println(o);
    }*/

}
