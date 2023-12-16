package oncall.domain.date;

public enum LegalHoliday {
    NEW_YEAR(Month.Jan, 1),
    INDEPENDENCE_MOVEMENT(Month.Mar, 1),
    CHILDREN_DAY(Month.May, 5),
    MEMORIAL_DAY(Month.Jun, 6),
    NATIONAL_LIBERATION(Month.Aug, 15),
    NATIONAL_FOUNDATION_DAY(Month.Oct, 3),
    HANGUL_DAY(Month.Oct, 9),
    CHRISTMAS(Month.Dec, 25);

    private final Month month;
    private final int day;

    LegalHoliday(Month month, int day) {
        this.month = month;
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
