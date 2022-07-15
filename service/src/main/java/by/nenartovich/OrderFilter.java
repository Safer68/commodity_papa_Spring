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

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFilter {
    private String client;
    private ManagerDto managerDto;
    private String dateCreateBefore;
    private String dateCreateFor;
    private Date dateChange;

    public Date gDateCreateBefore() {
        if (dateCreateBefore != null && dateCreateBefore != "") {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            try {
                Date date = format.parse(dateCreateBefore);
                return date;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public Date gDateCreateFor() {
        if (dateCreateFor != null && dateCreateFor != "") {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            try {
                Date date = format.parse(dateCreateFor);
                return date;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setDateCreateBefore(" ");
    }
}
