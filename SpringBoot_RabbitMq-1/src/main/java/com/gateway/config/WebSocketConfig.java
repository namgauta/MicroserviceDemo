package com.gateway.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	
	@Override
		public void configureMessageBroker(MessageBrokerRegistry registry) {
			// TODO Auto-generated method stub
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/vibranium");
		}
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry){
		// TODO Auto-generated method stub
		registry.addEndpoint("/trade").setAllowedOrigins("*").withSockJS();
	}
	
	
}
