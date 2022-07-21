package by.nenartovich;

public enum StatusOrder {
    PENDING_PROCESSING("Ждет обработки"),
    ACCEPTED_BY_MANAGER("Принят менеджером"),
    SENT ("Отправлен"),
    RECEIVED ("Получен"),
    RETURN ("Возврат");

    private String code;

    StatusOrder(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
