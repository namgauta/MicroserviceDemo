package com.gateway.config;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {

	@Autowired
	private SimpMessagingTemplate template;

	private final String queueName="user.queue";
	@RabbitListener(queues=queueName)
	public void subscriber(Map<Object,String> message) {
		System.out.println("aya "+ message);
		
		this.template.convertAndSend("/topic/userCreated",message);		
	}

}
