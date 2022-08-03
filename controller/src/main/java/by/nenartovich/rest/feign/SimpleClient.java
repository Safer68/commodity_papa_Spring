package by.nenartovich.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "sms-rest",url = "https://commodity-papa.herokuapp.com/")
public interface SimpleClient {
    @PostMapping(value = "/sms-rest", consumes = MediaType.APPLICATION_JSON_VALUE)
    String[] getSMS(@RequestBody String phone);
}
