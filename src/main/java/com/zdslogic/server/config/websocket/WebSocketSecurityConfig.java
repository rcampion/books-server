package com.zdslogic.server.config.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		messages.nullDestMatcher().permitAll().simpSubscribeDestMatchers("/user/queue/errors").permitAll()
				.simpDestMatchers("/chat", "/chat**", "/chat/**", "/chat/info*", "/live", "/live**", "/live/**",
						"/live/info*")
				.permitAll()
				.simpSubscribeDestMatchers("/chat", "/chat**", "/chat/**", "/chat/info*", "/live", "/live**",
						"/live/**", "/live/info*", "/topic/*")
				.permitAll().simpTypeMatchers(SimpMessageType.MESSAGE, SimpMessageType.SUBSCRIBE).permitAll()
				.simpTypeMatchers(SimpMessageType.CONNECT, SimpMessageType.UNSUBSCRIBE, SimpMessageType.DISCONNECT)
				.permitAll().anyMessage().permitAll();

	}

	@Override
	protected boolean sameOriginDisabled() {
		return true;
	}

}