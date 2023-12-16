package oncall.scheduler;

import java.util.List;
import oncall.domain.Schedule;
import oncall.ui.InputView;
import oncall.ui.OutputView;

public class OnCallScheduler {
    public void start() {
        getUserMonthStartDate();
        getWorkers();
    }

    private static void getWorkers() {
        try {
            getWeekDayWorker();
            getWeekEndWorker();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getWorkers();
        }
    }

    private static void getWeekEndWorker() {
        OutputView.printGetWeekEndNickNames();
        InputView.getWeekEndNicknames();
    }

    private static void getWeekDayWorker() {
        OutputView.printGetWeekDayNickNames();
        InputView.getWeekDayNicknames();
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
