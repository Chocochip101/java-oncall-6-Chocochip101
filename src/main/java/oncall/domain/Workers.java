package oncall.domain;

import static oncall.global.Config.INITIAL_INDEX;
import static oncall.global.Config.MIN_WORKER_SIZE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.domain.date.Month;
import oncall.domain.date.WeekDay;
import oncall.global.Config;
import oncall.global.DateUtil;

public class Workers {
    private final Worker weekDayWorkers;
    private final Worker weekEndWorkers;

    public Workers(List<String> weekDayWorkers, List<String> weekEndWorkers) {
        validate(weekDayWorkers, weekEndWorkers);
        this.weekDayWorkers = new Worker(weekDayWorkers);
        this.weekEndWorkers = new Worker(weekEndWorkers);
    }

    private void validate(List<String> weekDayWorkers, List<String> weekEndWorkers) {
        Set<String> workers = new HashSet<>();
        workers.addAll(weekDayWorkers);
        workers.addAll(weekEndWorkers);
        if (workers.size() > Config.MAX_WORKER_SIZE || workers.size() < MIN_WORKER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public WorkArrangement arrange(Schedule schedule) {
        List<String> workerArrangement = new ArrayList<>();
        List<WeekDay> weekDays = new ArrayList<>();

        WeekDay dayIndex = schedule.getWeekDay();
        for (int day = 1; day <= schedule.getMonth().getMaxDay(); ++day) {
            if (isHoliday(schedule.getMonth(), dayIndex, day)) {
                handleHoliday(schedule.getMonth(), workerArrangement, weekDays, dayIndex, day);
                dayIndex = dayIndex.getNextWeekDay();
                continue;
            }
            handleWeekDay(workerArrangement, weekDays, dayIndex);
            dayIndex = dayIndex.getNextWeekDay();
        }

        return new WorkArrangement(schedule, workerArrangement, weekDays);
    }

    private void handleHoliday(
            Month month, List<String> workerArrangement, List<WeekDay> weekDays, WeekDay dayIndex, int day) {
        Worker holidayWorkers = getWorker(month, dayIndex, day);

        if (workerArrangement.size() > INITIAL_INDEX
                && workerArrangement.get(workerArrangement.size() - 1).equals(holidayWorkers.checkNextPerson())) {
            holidayWorkers.changeOrder();
        }

        workerArrangement.add(holidayWorkers.getNextPerson());
        weekDays.add(dayIndex);
    }

    private Worker getWorker(Month month, WeekDay dayIndex, int day) {
        if (isHoliday(month, dayIndex, day)) {
            return weekEndWorkers;
        }
        return weekDayWorkers;

    }

    private void handleWeekDay(List<String> workerArrangement, List<WeekDay> weekDays, WeekDay dayIndex) {
        Worker currentWorkers = weekDayWorkers;

        if (workerArrangement.size() > INITIAL_INDEX &&
                workerArrangement.get(workerArrangement.size() - 1).equals(currentWorkers.checkNextPerson())) {
            currentWorkers.changeOrder();
        }

        workerArrangement.add(currentWorkers.getNextPerson());
        weekDays.add(dayIndex);
    }


    private boolean isHoliday(Month month, WeekDay dayIndex, int day) {
        if (isWeekEnd(dayIndex)) {
            return true;
        }
        if (DateUtil.isLegalHoliday(month, day)) {
            return true;
        }
        return false;
    }

    private boolean isWeekEnd(WeekDay day) {
        return day == WeekDay.Saturday || day == WeekDay.Sunday;
    }
}
