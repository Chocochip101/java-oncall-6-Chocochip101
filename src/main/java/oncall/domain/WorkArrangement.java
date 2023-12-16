package oncall.domain;

import java.util.List;
import oncall.domain.date.WeekDay;

public class WorkArrangement {
    private final Schedule schedule;
    private final List<String> workers;
    private final List<WeekDay> weekDays;

    public WorkArrangement(Schedule schedule, List<String> workers, List<WeekDay> weekDays) {
        this.schedule = schedule;
        this.workers = workers;
        this.weekDays = weekDays;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public List<String> getWorkers() {
        return workers;
    }

    public List<WeekDay> getWeekDays() {
        return weekDays;
    }
}
