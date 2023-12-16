package oncall.scheduler;

import oncall.domain.Schedule;
import oncall.ui.InputView;
import oncall.ui.OutputView;

public class OnCallScheduler {
    public void start() {
        getUserMonthStartDate();
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
