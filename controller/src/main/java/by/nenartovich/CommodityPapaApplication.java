package by.nenartovich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"by.nenartovich"})
public class CommodityPapaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommodityPapaApplication.class, args);
    }

}
