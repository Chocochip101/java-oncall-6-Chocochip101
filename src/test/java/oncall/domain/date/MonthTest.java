package oncall.domain.date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MonthTest {

    @Test
    @DisplayName("월 조회에 성공한다.")
    public void getMonthTest() {
        //given&when&then
        assertAll(
                () -> assertEquals(Month.Jan.getMonth(), 1),
                () -> assertEquals(Month.Feb.getMonth(), 2),
                () -> assertEquals(Month.Mar.getMonth(), 3),
                () -> assertEquals(Month.Apr.getMonth(), 4),
                () -> assertEquals(Month.May.getMonth(), 5),
                () -> assertEquals(Month.Jun.getMonth(), 6),
                () -> assertEquals(Month.Jul.getMonth(), 7),
                () -> assertEquals(Month.Aug.getMonth(), 8),
                () -> assertEquals(Month.Sep.getMonth(), 9),
                () -> assertEquals(Month.Oct.getMonth(), 10),
                () -> assertEquals(Month.Nov.getMonth(), 11),
                () -> assertEquals(Month.Dec.getMonth(), 12)
        );
    }


    @Test
    @DisplayName("각 월의 최대 날짜 조회에 성공한다.")
    public void getMonthMaxDayTest() {
        //given&when&then
        assertAll(
                () -> assertEquals(Month.Jan.getMaxDay(), 31),
                () -> assertEquals(Month.Feb.getMaxDay(), 28),
                () -> assertEquals(Month.Mar.getMaxDay(), 31),
                () -> assertEquals(Month.Apr.getMaxDay(), 30),
                () -> assertEquals(Month.May.getMaxDay(), 31),
                () -> assertEquals(Month.Jun.getMaxDay(), 30),
                () -> assertEquals(Month.Jul.getMaxDay(), 31),
                () -> assertEquals(Month.Aug.getMaxDay(), 31),
                () -> assertEquals(Month.Sep.getMaxDay(), 30),
                () -> assertEquals(Month.Oct.getMaxDay(), 31),
                () -> assertEquals(Month.Nov.getMaxDay(), 30),
                () -> assertEquals(Month.Dec.getMaxDay(), 31)
        );
    }
}