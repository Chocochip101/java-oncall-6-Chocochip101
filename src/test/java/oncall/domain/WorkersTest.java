package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import oncall.fixture.WorkersFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkersTest {
    List<String> weekDayWorkers;
    List<String> weekEndWorkers;

    @BeforeEach
    void setup() {
        weekDayWorkers = WorkersFixture.WeekDayWorkersFixture();
        weekEndWorkers = WorkersFixture.WeekEndWorkersFixture();
    }

    @Test
    @DisplayName("근무자 35명 이상일 경우, 예외가 발생한다.")
    public void testMoreThanWorkers() {
        //given
        List<String> people = new ArrayList<>();
        for (int i = 0; i < 36; ++i) {
            people.add("name" + i);
        }

        //when&then
        assertThatThrownBy(() -> new Workers(weekDayWorkers, people))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("근무자 5명보다 작을 경우, 예외가 발생한다.")
    public void testLessThanWorkers() {
        //given
        List<String> people = new ArrayList<>();
        for (int i = 0; i < 1; ++i) {
            people.add("name" + i);
        }

        //when&then
        assertThatThrownBy(() -> new Workers(people, people))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("근무자 배열에 성공한다.")
    public void testArrangement() {
        //given
        Workers workers = new Workers(weekDayWorkers, weekEndWorkers);
        Schedule schedule = new Schedule(List.of("5", "월"));

        //when
        WorkArrangement arrange = workers.arrange(schedule);

        //then
        assertEquals(arrange.getSchedule().getMonth(), schedule.getMonth());
        assertEquals(arrange.getSchedule().getWeekDay(), schedule.getWeekDay());
    }
}