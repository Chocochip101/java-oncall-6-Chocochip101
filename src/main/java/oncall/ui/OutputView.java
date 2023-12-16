package oncall.ui;

import static oncall.ui.OutputCommand.ERROR_PREFIX;
import static oncall.ui.OutputCommand.MONTH_START_DATE_INPUT_COMMAND;
import static oncall.ui.OutputCommand.WEEKDAY_NICKNAME_INPUT_COMMAND;

public class OutputView {
    public static void printMonthStartDateInput() {
        System.out.print(MONTH_START_DATE_INPUT_COMMAND);
    }

    public static void printGetWeekDayNickNames() {
        System.out.print(WEEKDAY_NICKNAME_INPUT_COMMAND);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
