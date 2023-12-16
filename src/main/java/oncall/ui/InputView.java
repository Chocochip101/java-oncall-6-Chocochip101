package oncall.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> getMonthStartDate() {
        return Arrays.stream(Console.readLine().split(",")).map(String::trim).collect(Collectors.toList());
    }
}
