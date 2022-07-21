package by.nenartovich;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {
    private String str;
    private String str2;
    @Builder.Default
    private String sortField = "id";
    @Builder.Default
    private String sortDir = "asc";
    @Builder.Default
    private int pageSize = 11;
    private int getTotalPages;
    private long getTotalElements;
    @Builder.Default
    private int pageNumber = 1;
    private String dateCreate2;
}
