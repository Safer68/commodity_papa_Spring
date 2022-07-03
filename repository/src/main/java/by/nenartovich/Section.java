package by.nenartovich;


public enum Section {
    SPORT("S"), MUSIC("M"), TECHNOLOGY("T");

    private String code;

    Section(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
