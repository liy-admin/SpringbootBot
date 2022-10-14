import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.l96.tg.bot.Application;
import xyz.l96.tg.bot.services.SmsApiService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class testApi {
    @Autowired
    SmsApiService sdf;


    @Test
    void smsSend(){
        System.out.println(sdf.getBalance());
    }
}
