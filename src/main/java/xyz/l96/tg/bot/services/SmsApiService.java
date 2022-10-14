package xyz.l96.tg.bot.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

public interface SmsApiService {
    String getProjectName();
    String getPhone(int country,String service);
    String getStatus();
    String getBalance();

}
