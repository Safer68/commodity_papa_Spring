package by.nenartovich.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "sms-rest",url = "http://localhost:8076/")
public interface SimpleClient {
    @PostMapping(value = "/sms-rest", consumes = MediaType.APPLICATION_JSON_VALUE)
    String[] getSMS(@RequestBody String phone);
}
