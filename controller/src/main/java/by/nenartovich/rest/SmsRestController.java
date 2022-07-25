package by.nenartovich.rest;

import by.nenartovich.smsc_api.Smsc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms-rest")
@RequiredArgsConstructor
public class SmsRestController {

    @GetMapping()
    public String[] getHorse(String phones) {
        Smsc sd = new Smsc("Schurko", "loxerman1");
        return sd.send_sms(phones, "Ваш пароль: 123", 1, "", "1", 0, "", "");
    }
}
