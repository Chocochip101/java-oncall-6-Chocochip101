package oncall.ui;

import static oncall.ui.OutputCommand.ERROR_PREFIX;
import static oncall.ui.OutputCommand.HOLIDAY_ARRANGEMENT_OUTPUT;
import static oncall.ui.OutputCommand.MONTH_START_DATE_INPUT_COMMAND;
import static oncall.ui.OutputCommand.WEEKDAY_ARRANGEMENT_OUTPUT;
import static oncall.ui.OutputCommand.WEEKDAY_NICKNAME_INPUT_COMMAND;
import static oncall.ui.OutputCommand.WEEKEND_NICKNAME_INPUT_COMMAND;

import oncall.domain.WorkArrangement;
import oncall.domain.date.Month;
import oncall.domain.date.WeekDay;
import oncall.global.DateUtil;

public class OutputView {
    public static void printMonthStartDateInput() {
        System.out.print(MONTH_START_DATE_INPUT_COMMAND);
    }

    public static void printGetWeekDayNickNames() {
        System.out.print(WEEKDAY_NICKNAME_INPUT_COMMAND);
    }

    public static void printGetWeekEndNickNames() {
        System.out.print(WEEKEND_NICKNAME_INPUT_COMMAND);
    }

    public static void printWorkersArrangement(WorkArrangement workArrangement) {
        printNewLine();
        for (int day = 1; day <= workArrangement.getSchedule().getMonth().getMaxDay(); ++day) {
            printWorker(
                    workArrangement.getSchedule().getMonth(),
                    day,
                    workArrangement.getWeekDays().get(day - 1),
                    workArrangement.getWorkers().get(day - 1));
        }
    }

    private static void printWorker(Month month, int day, WeekDay weekDay, String name) {
        if (DateUtil.isLegalHoliday(month, day) && !DateUtil.isWeekEnd(weekDay)) {
            System.out.println(
                    String.format(HOLIDAY_ARRANGEMENT_OUTPUT, month.getMonth(), day, weekDay.getWeekday(), name));
            return;
        }
        System.out.println(
                String.format(WEEKDAY_ARRANGEMENT_OUTPUT, month.getMonth(), day, weekDay.getWeekday(), name));
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
