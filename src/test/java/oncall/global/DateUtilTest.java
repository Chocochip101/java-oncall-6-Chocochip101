package oncall.global;

import static org.junit.jupiter.api.Assertions.*;

import oncall.domain.date.Month;
import oncall.domain.date.WeekDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateUtilTest {
    @Test
    @DisplayName("요일 조회에 성공한다.")
    public void getWeekDayTest() {
        //given
        WeekDay weekDay = WeekDay.Sunday;

        //when
        WeekDay day = DateUtil.findWeekDay("일");

        //then
        assertEquals(day, weekDay);
    }

    @Test
    @DisplayName("월 조회에 성공한다.")
    public void getMonthTest() {
        //given
        Month month = Month.Dec;

        //when
        Month found = DateUtil.findMonth("12");

        //then
        assertEquals(month, found);
    }

    @Test
    @DisplayName("법정 공휴일인지 검증한다.")
    public void testIsLegalHoliday() {
        //given
        Month month = Month.Dec;
        int day = 25;

        //when&then
        assertTrue(DateUtil.isLegalHoliday(month, day));
    }
}