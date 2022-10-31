package xyz.l96.tg.bot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;
import xyz.l96.tg.bot.services.JieMa;
import xyz.l96.tg.bot.services.SmsApiService;

import java.util.ArrayList;
import java.util.List;

@Service
public class JieMaImpl implements JieMa {

    @Autowired
    private SmsApiService smsApiService;

    @Override
    public List<InlineQueryResult> getService() {
        List<InlineQueryResult> list = new ArrayList<>();
        String projectName = smsApiService.getProjectName();
        return list;
    }
}
