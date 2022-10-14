package xyz.l96.tg.bot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.l96.tg.bot.services.SmsApiService;

import java.util.HashMap;

@Service
public class SmsManApiServiceImpl implements SmsApiService {
    @Value("${SMS-MAN.url}")
    @NonNull
    private String url;
    @Value("${SMS-MAN.token}")
    @NonNull
    private String token;


    @Autowired
    private RestTemplate restTemplate;

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder){
//        return builder.build();
//    }

    @Override
    public String getProjectName() {
        StringBuilder builder = new StringBuilder(url);
        builder.append("action=getServices&");
        builder.append(token);
        System.out.println(builder.toString());
        return restTemplate.getForObject(builder.toString(), String.class);
    }

    @Override
    public String getPhone(@Nullable int country,@Nullable String service) {
        StringBuilder builder = new StringBuilder(url);
        builder.append("action=getPrices&");
        builder.append(token);
        builder.append("country="+country+"&");
        builder.append("service="+service);
        return restTemplate.getForObject(builder.toString(),String.class);
    }

//
//    状态？？？
    @Override
    public String getStatus() {
        StringBuilder builder = new StringBuilder(url);
        builder.append("action=getStatus&");
        builder.append(token);
        builder.append("id=");
        return null;
    }

    @Override
    public String getBalance() {
        StringBuilder builder = new StringBuilder(url);
        builder.append("action=getBalance&");
        builder.append(token);
        String[] strings = restTemplate.getForObject(builder.toString(), String[].class);
        strings[0] = "您的余额还有：";
        return strings.toString();
    }
}
