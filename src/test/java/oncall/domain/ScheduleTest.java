package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import oncall.domain.date.Month;
import oncall.domain.date.WeekDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScheduleTest {
    @Test
    @DisplayName("스케줄 생성에 성공한다.")
    public void createSchedule() {
        //given
        List<String> input = List.of("3", "월");

        //when
        Schedule schedule = new Schedule(input);

        //then
        assertEquals(schedule.getMonth(), Month.Mar);
        assertEquals(schedule.getWeekDay(), WeekDay.Monday);
    }

    @Test
    @DisplayName("날짜 범위 이외의 월 입력 시, 예외가 발생한다.")
    public void testMonthOutOfRange() {
        //given
        List<String> input = List.of("0", "월");

        // when&then
        assertThatThrownBy(() -> new Schedule(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("부적절한 요일 입력 시, 예외가 발생한다.")
    public void testWrongWeekDay() {
        //given
        List<String> input = List.of("2", "크");

        // when&then
        assertThatThrownBy(() -> new Schedule(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}