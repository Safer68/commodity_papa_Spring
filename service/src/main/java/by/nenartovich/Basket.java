package by.nenartovich;

import by.nenartovich.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
public class Basket {
    private static final int INT = 0;
    @Builder.Default
    private List<ProductDto> basket = new ArrayList<>();
    @Builder.Default
    private Integer size = INT;

    public void add(ProductDto productDto) {
        this.basket.add(productDto);
        this.size = basket.size();
    }

    public void remove(ProductDto productDto) {
        basket.remove(productDto);
        this.size = basket.size();
    }

    public void clear() {
        basket.clear();
        this.size = basket.size();
    }
}
