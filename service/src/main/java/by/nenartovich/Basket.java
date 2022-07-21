package by.nenartovich;

import by.nenartovich.dto.ProductDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Component
@SessionScope
public class Basket {
    private List<ProductDto> basket = new ArrayList<>();

    public void add(ProductDto productDto) {
        basket.add(productDto);
    }

    public void remove(ProductDto productDto) {
        basket.remove(productDto);
    }

    public void clear() {
        basket.clear();
    }

}
