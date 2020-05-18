package domain.card;

public enum Type {
    SPADE("스페이드"),
    DIAMOND("다이아몬"),
    HEART("하트"),
    CLUB("클로버");

    private String title;

    Type(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
