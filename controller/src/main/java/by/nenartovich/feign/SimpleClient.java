package by.nenartovich.feign;

import by.nenartovich.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "sms-rest",url = "http://localhost:8076/")
public interface SimpleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/sms-rest")
    String[] getSMS(String phones);
}
