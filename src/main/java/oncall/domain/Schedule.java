package oncall.domain;

import java.util.List;
import oncall.domain.date.Month;
import oncall.domain.date.WeekDay;
import oncall.global.Config;
import oncall.global.DateUtil;

public class Schedule {
    private final Month month;
    private final WeekDay weekDay;

    public Schedule(List<String> input) {
        this.month = DateUtil.findMonth(input.get(Config.INPUT_MONTH_PART));
        this.weekDay = DateUtil.findWeekDay(input.get(Config.INPUT_WEEKDAY_PART));
    }

    public Month getMonth() {
        return month;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }
}
