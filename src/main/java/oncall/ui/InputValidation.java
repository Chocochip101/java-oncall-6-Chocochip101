package oncall.ui;

import static oncall.global.ErrorMessage.INVALID_DATE_ERROR;

public class InputValidation {
    static void validIsNumber(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }
}
