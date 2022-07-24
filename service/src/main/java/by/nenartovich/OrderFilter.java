package by.nenartovich;

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
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private String clientName;
    private String managerName;
    private String dateCreateBefore;
    private String dateCreateFor;
    private StatusOrder statusOrder;
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
    public void cline(){

        this.dateCreateBefore= null;
        this.dateCreateFor= null;
        this.statusOrder= null;
    }
}
