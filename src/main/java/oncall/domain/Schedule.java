package oncall.domain;

import static oncall.global.DateUtil.MAX_MONTH;
import static oncall.global.DateUtil.MIN_MONTH;
import static oncall.global.ErrorMessage.INVALID_DATE_ERROR;

import java.util.List;
import oncall.domain.date.WeekDay;
import oncall.global.Config;
import oncall.global.DateUtil;

public class Schedule {
    private final int month;
    private final WeekDay weekDay;

    public Schedule(List<String> input) {
        validate(input);
        this.month = Integer.parseInt(input.get(Config.INPUT_MONTH_PART));
        this.weekDay = DateUtil.findWeekDay(input.get(Config.INPUT_WEEKDAY_PART));
    }

    private void validate(List<String> input) {
        validMonth(Integer.parseInt(input.get(Config.INPUT_MONTH_PART)));
    }

    private void validMonth(int month) {
        if (!isInRange(month, MIN_MONTH, MAX_MONTH)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }

    private boolean isInRange(final int userDate, final int minDate, final int maxDate) {
        return minDate <= userDate && userDate <= maxDate;
    }

    public int getMonth() {
        return month;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }
}
