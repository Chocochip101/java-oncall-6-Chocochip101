package oncall.domain.date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekDayTest {
    @Test
    @DisplayName("다음 요일 조회에 성공한다.")
    public void getNextWeekDayTest() throws Exception {
        //given
        WeekDay now = WeekDay.Sunday;

        //when
        WeekDay nextDay = now.getNextWeekDay();

        //then
        assertEquals(nextDay.getWeekday(), WeekDay.Monday.getWeekday());
    }
}