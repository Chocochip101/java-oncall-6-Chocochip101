package oncall.fixture;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.Worker;

public class WorkersFixture {
    public static List<String> WeekDayWorkersFixture() {
        List<String> people = new ArrayList<>();
        people.add("준팍");
        people.add("도밥");
        people.add("고니");
        people.add("수아");
        people.add("루루");
        people.add("글로");
        people.add("솔로스타");
        people.add("우코");
        people.add("슬리킹");
        people.add("참새");
        people.add("도리");
        return people;
    }

    public static List<String> WeekEndWorkersFixture() {
        List<String> people = new ArrayList<>();
        people.add("수아");
        people.add("루루");
        people.add("글로");
        people.add("솔로스타");
        people.add("우코");
        people.add("슬링키");
        people.add("참새");
        people.add("도리");
        people.add("준팍");
        people.add("도밥");
        people.add("고니");
        return people;
    }
}
