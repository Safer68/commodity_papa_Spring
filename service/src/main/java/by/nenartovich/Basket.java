package by.nenartovich;

import by.nenartovich.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
public class Basket {
    @Builder.Default
    private List<ProductDto> basket = new ArrayList<>();
    @Builder.Default
    private Integer size = 0;

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
