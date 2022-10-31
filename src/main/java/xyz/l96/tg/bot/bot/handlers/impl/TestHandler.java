package xyz.l96.tg.bot.bot.handlers.impl;

import com.github.unafraid.telegrambot.bots.AbstractTelegramBot;
import com.github.unafraid.telegrambot.handlers.ICommandHandler;
import com.github.unafraid.telegrambot.handlers.inline.AbstractInlineHandler;
import com.github.unafraid.telegrambot.handlers.inline.InlineContext;
import com.github.unafraid.telegrambot.handlers.inline.InlineMenuBuilder;
import com.github.unafraid.telegrambot.util.BotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonPollType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import xyz.l96.tg.bot.services.SmsApiService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TestHandler extends AbstractInlineHandler implements ICommandHandler {
    @Autowired
    SmsApiService sms;

    @Override
    public String getCommand() {
        return "/test";
    }

    @Override
    public String getUsage() {
        return "/test";
    }

    @Override
    public String getDescription() {
        return "test";
    }

    @Override
    public void registerMenu(InlineContext ctx, InlineMenuBuilder builder) {
    }

    @Override
    public void onCommandMessage(AbstractTelegramBot bot, Update update, Message message, List<String> args) throws TelegramApiException {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        KeyboardRow row = new KeyboardRow();
        row.add(KeyboardButton.builder()
                .text("查看业务")
                .build());
        row.add(KeyboardButton.builder()
                .text("购买业务")
                .build());


        markup.setResizeKeyboard(true);
        markup.setInputFieldPlaceholder("请选择你想要的业务！");
        markup.setKeyboard(Collections.singletonList(row));
//        发送消息
        BotUtil.sendMessage(bot,message,"test",true,true,markup);
//        使用说明
//        BotUtil.sendUsage(bot,message,new HelpHandler());
//
        BotUtil.sendAction(bot,message, ActionType.TYPING);



    }

    @Override
    public boolean onCallbackQuery(AbstractTelegramBot bot, Update update, CallbackQuery query) throws TelegramApiException {
        if (update.getCallbackQuery().getMessage().getText().contains("查看业务")){
            BotUtil.sendMessage(bot,update.getMessage(),"hihihi",false,false,null);
        }
        return true;
    }
}
