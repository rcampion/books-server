package com.zdslogic.server.config.websocket;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.zdslogic.server.utils.SystemInfo;

@Configuration
@ConfigurationProperties
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	//@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/topic", "/app");
	}

	//@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry) {
		registry.addEndpoint(SystemInfo.apiPrefix + "/ws").setAllowedOrigins("https://www.zdslogic.com", "http://www.richardcampion.com", "http://www.brentfisher.me", "http://www.paulfredette.me", "http://www.monicaconnors.com", "http://localhost:4200", "http://localhost:8089").withSockJS();		
		registry.addEndpoint("/live").setAllowedOrigins("https://www.zdslogic.com", "http://www.richardcampion.com", "http://www.brentfisher.me", "http://www.paulfredette.me", "http://www.monicaconnors.com", "http://localhost:4200", "http://localhost:8089").withSockJS().setHeartbeatTime(1000);
		registry.addEndpoint("/chat");
		registry.addEndpoint("/chat").withSockJS();
		registry.addEndpoint("/chatwithbots");
		registry.addEndpoint("/chatwithbots").withSockJS();
	}

}