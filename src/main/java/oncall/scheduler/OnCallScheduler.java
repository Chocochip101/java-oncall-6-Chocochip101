package oncall.scheduler;

import java.util.List;
import oncall.domain.Schedule;
import oncall.ui.InputView;
import oncall.ui.OutputView;

public class OnCallScheduler {
    public void start() {
        getUserMonthStartDate();
        getWeekDayWorkers();
    }

    private static List<String> getWeekDayWorkers() {
        try {
            OutputView.printGetWeekDayNickNames();
            return InputView.getWeekDayNicknames();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWeekDayWorkers();
        }
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
