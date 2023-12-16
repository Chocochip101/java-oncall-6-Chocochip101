package oncall.scheduler;

import oncall.ui.InputView;
import oncall.ui.OutputView;

public class OnCallScheduler {
    public void start() {
        OutputView.printMonthStartDateInput();
        InputView.getMonthStartDate();
    }
}
