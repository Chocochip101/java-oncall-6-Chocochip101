package oncall.ui;

import static oncall.global.ErrorMessage.INVALID_DATE_ERROR;
import static oncall.global.ErrorMessage.INVALID_NICKNAME_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.global.Config;

public class InputValidation {
    static void validIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }

    static void validNickNames(List<String> nicknames) {
        checkMaxLength(nicknames);
        checkDuplication(nicknames);
    }

    private static void checkMaxLength(List<String> nicknames) {
        for (String nickname : nicknames) {
            if (nickname.length() > Config.NICKNAME_MAX_SIZE) {
                throw new IllegalArgumentException(INVALID_NICKNAME_ERROR.getMessage());
            }
        }
    }

    private static void checkDuplication(List<String> nicknames) {
        Set<String> uniqueNicknames = new HashSet<>();
        for (String nickname : nicknames) {
            if (!uniqueNicknames.add(nickname)) {
                throw new IllegalArgumentException(INVALID_NICKNAME_ERROR.getMessage());
            }
        }
    }
}
