package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkerTest {
    List<String> people;

    @BeforeEach
    void setup() {
        people = new ArrayList<>();
        people.add("준팍");
        people.add("도밥");
        people.add("고니");
        people.add("수아");
    }

    @Test
    @DisplayName("비상 근무자 순서 생성에 성공한다.")
    public void createWorkerTest() {
        //given&when
        Worker worker = new Worker(people);

        //then
        assertEquals(worker.checkNextPerson(), "준팍");
    }

    @Test
    @DisplayName("비상 근무자 순서에서 다음 근무자 조회에 성공한다.")
    public void getNextWorkerTest() {
        //given&when
        Worker worker = new Worker(people);

        //then
        assertAll(
                () -> assertEquals(worker.checkNextPerson(), "준팍"),
                () -> assertEquals(worker.getNextPerson(), "준팍"),
                () -> assertEquals(worker.getNextPerson(), "도밥"),
                () -> assertEquals(worker.getNextPerson(), "고니"),
                () -> assertEquals(worker.getNextPerson(), "수아"),
                () -> assertEquals(worker.getNextPerson(), "준팍")
        );
    }

    @Test
    @DisplayName("비상 근무자 순서 변경에 성공한다.")
    public void changeNextWorkerTest() {
        //given
        Worker worker = new Worker(people);

        //when
        worker.changeOrder();

        //then
        assertAll(
                () -> assertEquals(worker.checkNextPerson(), "도밥"),
                () -> assertEquals(worker.getNextPerson(), "도밥"),
                () -> assertEquals(worker.getNextPerson(), "준팍"),
                () -> assertEquals(worker.getNextPerson(), "고니"),
                () -> assertEquals(worker.getNextPerson(), "수아"),
                () -> assertEquals(worker.getNextPerson(), "도밥")
        );
    }
}