package xyz.l96.tg.bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

/**
 * @author UnAfraid
 */
@Configuration
public class DefaultBotOptionsConfig {
	@Bean
	public DefaultBotOptions newDefaultBotOptions() {
		final DefaultBotOptions defaultBotOptions = new DefaultBotOptions();
		
		// XXX: set additional bot options such as Proxy here
//		defaultBotOptions.setProxyType(DefaultBotOptions.ProxyType.HTTP);
//		defaultBotOptions.setProxyHost("127.0.0.1");
//		defaultBotOptions.setProxyPort(10809);
		return defaultBotOptions;
	}
}
