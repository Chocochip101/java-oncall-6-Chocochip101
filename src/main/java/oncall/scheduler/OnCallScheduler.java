package oncall.scheduler;

import java.util.List;
import oncall.domain.Schedule;
import oncall.domain.Workers;
import oncall.ui.InputView;
import oncall.ui.OutputView;

public class OnCallScheduler {
    public void start() {
        Schedule schedule = getUserMonthStartDate();
        Workers workers = getWorkers();
        OutputView.printWorkersArrangement(workers.arrange(schedule));
    }

    private static Workers getWorkers() {
        try {
            return new Workers(getWeekDayWorker(), getWeekEndWorker());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWorkers();
        }
    }

    private static List<String> getWeekEndWorker() {
        OutputView.printGetWeekEndNickNames();
        return InputView.getWeekEndNicknames();
    }

    private static List<String> getWeekDayWorker() {
        OutputView.printGetWeekDayNickNames();
        return InputView.getWeekDayNicknames();
    }

    private static Schedule getUserMonthStartDate() {
        try {
            OutputView.printMonthStartDateInput();
            return new Schedule(InputView.getMonthStartDate());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserMonthStartDate();
        }
    }
}
