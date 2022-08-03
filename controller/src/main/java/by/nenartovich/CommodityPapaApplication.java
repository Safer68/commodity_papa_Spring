package by.nenartovich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients
public class CommodityPapaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommodityPapaApplication.class, args);
    }

}
