package oncall.domain.date;

public enum WeekDay {
    Monday("월"),
    Tuesday("화"),
    Wednesday("수"),
    Thursday("목"),
    Friday("금"),
    Saturday("토"),
    Sunday("일");
    private final String weekday;

    WeekDay(String weekday) {
        this.weekday = weekday;
    }

    public String getWeekday() {
        return weekday;
    }

    public WeekDay getNextWeekDay() {
        int currentIndex = this.ordinal();
        int nextIndex = (currentIndex + 1) % WeekDay.values().length;
        return WeekDay.values()[nextIndex];
    }
}
