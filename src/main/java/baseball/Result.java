package baseball;

public enum Result {
    STRIKE("strike"),
    BALL("ball"),
    NOTHING("nothing");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
