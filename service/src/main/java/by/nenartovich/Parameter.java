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
    private static final String ID = "id";
    private static final String ASC = "asc";
    private static final int PAGE_SIZE = 11;
    private static final int PAGE_NUMBER = 1;
    private String str;
    private String str2;
    @Builder.Default
    private String sortField = ID;
    @Builder.Default
    private String sortDir = ASC;
    @Builder.Default
    private int pageSize = PAGE_SIZE;
    private int getTotalPages;
    private long getTotalElements;
    @Builder.Default
    private int pageNumber = PAGE_NUMBER;
    private String dateCreate2;
}
