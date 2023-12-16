package oncall.domain.date;

public enum Month {
    Jan(1, 31),
    Feb(2, 28),
    Mar(3, 31),
    Apr(4, 30),
    May(5, 31),
    Jun(6, 30),
    Jul(7, 31),
    Aug(8, 31),
    Sep(9, 30),
    Oct(10, 31),
    Nov(11, 30),
    Dec(12, 31);

    private final int month;
    private final int maxDay;

    Month(int month, int maxDay) {
        this.month = month;
        this.maxDay = maxDay;
    }

    public int getMonth() {
        return month;
    }

    public int getMaxDay() {
        return maxDay;
    }
}
