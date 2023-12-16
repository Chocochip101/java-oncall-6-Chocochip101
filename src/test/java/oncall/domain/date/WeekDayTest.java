package oncall.domain.date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekDayTest {
    @Test
    @DisplayName("요일 조회에 성공한다.")
    public void getWeekDayTest() {
        //given&when&then
        assertAll(
                () -> assertEquals(WeekDay.Monday.getWeekday(), "월"),
                () -> assertEquals(WeekDay.Tuesday.getWeekday(), "화"),
                () -> assertEquals(WeekDay.Wednesday.getWeekday(), "수"),
                () -> assertEquals(WeekDay.Thursday.getWeekday(), "목"),
                () -> assertEquals(WeekDay.Friday.getWeekday(), "금"),
                () -> assertEquals(WeekDay.Saturday.getWeekday(), "토"),
                () -> assertEquals(WeekDay.Sunday.getWeekday(), "일")
        );
    }

    @Test
    @DisplayName("다음 요일 조회에 성공한다.")
    public void getNextWeekDayTest() {
        //given
        WeekDay now = WeekDay.Sunday;

        //when
        WeekDay nextDay = now.getNextWeekDay();

        //then
        assertEquals(nextDay.getWeekday(), WeekDay.Monday.getWeekday());
    }
}