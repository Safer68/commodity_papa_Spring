package by.nenartovich;

import by.nenartovich.dto.ManagerDto;
import by.nenartovich.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFilter {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private String client;
    private ManagerDto managerDto;
    private String dateCreateBefore;
    private String dateCreateFor;
    private Date dateChange;

    public Date gDateCreateBefore() {
        return getDate(dateCreateBefore);
    }

    public Date gDateCreateFor() {
        return getDate(dateCreateFor);
    }

    private Date getDate(String dateCreate) {
        if (dateCreate == null || "".equals(dateCreate)) {
            return null;
        }
        try {
            return SIMPLE_DATE_FORMAT.parse(dateCreate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}