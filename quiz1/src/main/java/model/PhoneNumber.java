package model;

public class PhoneNumber {
    private String number;
    private String label;

    public PhoneNumber(String number, String label) {
        this.number = number;
        this.label = label;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toJson() {
        return "{"
                + "\"number\":\"" + JsonUtils.escape(number) + "\","
                + "\"label\":\"" + JsonUtils.escape(label) + "\""
                + "}";
    }
}
