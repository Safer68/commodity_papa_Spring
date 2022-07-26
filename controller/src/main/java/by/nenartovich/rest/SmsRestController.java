package by.nenartovich.rest;

import by.nenartovich.smsc_api.Smsc;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms-rest")
@RequiredArgsConstructor
@PropertySource("classpath:smsConfig.properties")
public class SmsRestController {
    @Value("${login}")
    String login;
    @Value("${password}")
    String password;
    @Value("${massage}")
    String massage;

    @PostMapping()
    public String[] getQueryResult(@RequestBody String phone) {

        Smsc sd = new Smsc(login, password);
        return sd.send_sms(phone, massage, 1, "", "", 0, "", "");
    }
}
