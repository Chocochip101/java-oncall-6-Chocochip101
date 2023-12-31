package oncall.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import oncall.global.Config;

public class InputView {
    public static List<String> getMonthStartDate() {
        List<String> input = Arrays.stream(Console.readLine().split(",")).map(String::trim)
                .collect(Collectors.toList());
        InputValidation.validIsNumber(input.get(Config.INPUT_MONTH_PART));
        return input;
    }

    public static List<String> getWeekDayNicknames() {
        List<String> nicknames = Arrays.stream(Console.readLine().split(",")).map(String::trim)
                .collect(Collectors.toList());
        InputValidation.validNickNames(nicknames);
        return nicknames;
    }

    public static List<String> getWeekEndNicknames() {
        List<String> nicknames = Arrays.stream(Console.readLine().split(",")).map(String::trim)
                .collect(Collectors.toList());
        InputValidation.validNickNames(nicknames);
        return nicknames;
    }
}
