package xyz.l96.tg.bot.controllers;

import org.springframework.util.StringUtils;
import xyz.l96.tg.bot.bot.handlers.impl.StartHandler;
import xyz.l96.tg.bot.services.TelegramBotService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author UnAfraid
 */
@RestController
public class MainController {
	private final TelegramBotService telegramBotService;
	
	public MainController(TelegramBotService telegramBotService) {
		this.telegramBotService = telegramBotService;
	}
	
	@RequestMapping(value = "/callback/${TELEGRAM.TOKEN}", method = RequestMethod.POST)
	@ResponseBody
	public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
		if (update != null) {
//			this.setZHHandler(update);
		}
		return telegramBotService.onWebhookUpdateReceived(update);
	}


	private void setZHHandler(Update update){
		String text = null;
		if (update.hasMessage()) {
			text = update.getMessage().getText();
		}

		if (StringUtils.hasText(text)) {
			switch (text) {
				case "查看业务":
					update.getMessage().setText(text.replace("查看业务", "/select"));
					break;
			}
		}

	}
}
