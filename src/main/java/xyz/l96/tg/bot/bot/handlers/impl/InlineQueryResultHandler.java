package xyz.l96.tg.bot.bot.handlers.impl;

import com.github.unafraid.telegrambot.bots.AbstractTelegramBot;
import com.github.unafraid.telegrambot.handlers.ICommandHandler;
import com.github.unafraid.telegrambot.handlers.IInlineQueryHandler;
import com.github.unafraid.telegrambot.handlers.inline.*;
import com.github.unafraid.telegrambot.util.BotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.webapp.AnswerWebAppQuery;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.games.CallbackGame;
import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import xyz.l96.tg.bot.services.JieMa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class InlineQueryResultHandler implements IInlineQueryHandler,ICommandHandler {

    @Autowired
    private JieMa jm;


    @Override
    public String getCommand() {
        return "/adf";
    }

    @Override
    public String getUsage() {
        return "null";
    }

    @Override
    public String getDescription() {
        return "null";
    }

    @Override
    public void onCommandMessage(AbstractTelegramBot bot, Update update, Message message, List<String> args) throws TelegramApiException {

    }


    @Override
    public boolean onInlineQuery(AbstractTelegramBot bot, Update update, InlineQuery query) throws TelegramApiException {

        switch (query.getQuery()){
            case "service":
                selectService(bot, update,query);
                break;
        }
        return true;
    }



    private boolean selectService(AbstractTelegramBot bot , Update update,InlineQuery query) throws TelegramApiException {
        bot.execute(AnswerInlineQuery.builder()
                .inlineQueryId(query.getId())
                .results(jm.getService())
                .build()
        );
        return true;
    }

}
