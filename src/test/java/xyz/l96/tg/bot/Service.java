package xyz.l96.tg.bot;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.l96.tg.bot.Application;
import xyz.l96.tg.bot.services.JieMa;
import xyz.l96.tg.bot.services.impl.JieMaImpl;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service {
    @Autowired
    JieMa jieMa;
    @Autowired
    Gson gson;

    @Test
    public void getService(){
        List service = jieMa.getService();
        List list = gson.fromJson(String.valueOf(service), List.class);
        System.out.println(list.size());
    }
}
