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
            OutputView.printGetWeekDayNickNames();
            InputView.getWeekDayNicknames();
            OutputView.printGetWeekEndNickNames();
            InputView.getWeekEndNicknames();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getWorkers();
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
