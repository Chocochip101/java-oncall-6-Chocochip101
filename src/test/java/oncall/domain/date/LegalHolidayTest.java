package oncall.domain.date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LegalHolidayTest {

    @Test
    @DisplayName("법정 공휴일의 월을 검증한다.")
    public void testLegalHolidayMonth() {
        //given&when&then
        assertAll(
                () -> assertEquals(LegalHoliday.NEW_YEAR.getMonth(), Month.Jan),
                () -> assertEquals(LegalHoliday.INDEPENDENCE_MOVEMENT.getMonth(), Month.Mar),
                () -> assertEquals(LegalHoliday.CHILDREN_DAY.getMonth(), Month.May),
                () -> assertEquals(LegalHoliday.MEMORIAL_DAY.getMonth(), Month.Jun),
                () -> assertEquals(LegalHoliday.NATIONAL_LIBERATION.getMonth(), Month.Aug),
                () -> assertEquals(LegalHoliday.NATIONAL_FOUNDATION_DAY.getMonth(), Month.Oct),
                () -> assertEquals(LegalHoliday.HANGUL_DAY.getMonth(), Month.Oct),
                () -> assertEquals(LegalHoliday.CHRISTMAS.getMonth(), Month.Dec)
        );
    }

    @Test
    @DisplayName("법정 공휴일의 일자를 검증한다.")
    public void testLegalHolidayDay() {
        //given&when&then
        assertAll(
                () -> assertEquals(LegalHoliday.NEW_YEAR.getDay(), 1),
                () -> assertEquals(LegalHoliday.INDEPENDENCE_MOVEMENT.getDay(), 1),
                () -> assertEquals(LegalHoliday.CHILDREN_DAY.getDay(), 5),
                () -> assertEquals(LegalHoliday.MEMORIAL_DAY.getDay(), 6),
                () -> assertEquals(LegalHoliday.NATIONAL_LIBERATION.getDay(), 15),
                () -> assertEquals(LegalHoliday.NATIONAL_FOUNDATION_DAY.getDay(), 3),
                () -> assertEquals(LegalHoliday.HANGUL_DAY.getDay(), 9),
                () -> assertEquals(LegalHoliday.CHRISTMAS.getDay(), 25)
        );
    }
}