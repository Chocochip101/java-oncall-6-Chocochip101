package oncall.global;

import static oncall.global.ErrorMessage.INVALID_DATE_ERROR;

import oncall.domain.date.Month;
import oncall.domain.date.WeekDay;

public class DateUtil {
    public static int MIN_MONTH = 1;
    public static int MAX_MONTH = 12;

    public static WeekDay findWeekDay(String weekday) {
        for (WeekDay day : WeekDay.values()) {
            if (day.getWeekday().equals(weekday)) {
                return day;
            }
        }
        throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
    }

    public static Month findMonth(String month) {
        for (Month m : Month.values()) {
            if (m.getMonth() == Integer.parseInt(month)) {
                return m;
            }
        }
        throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
    }
}
