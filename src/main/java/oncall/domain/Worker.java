package oncall.domain;

import static oncall.global.Config.INITIAL_INDEX;
import static oncall.global.Config.NEXT_PERSON;

import java.util.List;

public class Worker {
    private List<String> worker;
    private int nextPerson;

    public Worker(List<String> worker) {
        this.worker = worker;
        nextPerson = INITIAL_INDEX;
    }

    public String getNextPerson() {
        if (nextPerson == worker.size()) {
            nextPerson = INITIAL_INDEX;
        }
        return worker.get(nextPerson++);
    }

    public String checkNextPerson() {
        if (nextPerson == worker.size()) {
            nextPerson = INITIAL_INDEX;
        }
        return worker.get(nextPerson);
    }

    public void changeOrder() {
        if (nextPerson < getLastIndex()) {
            String temp = worker.get(nextPerson);
            worker.set(nextPerson, worker.get(nextPerson + NEXT_PERSON));
            worker.set(nextPerson + NEXT_PERSON, temp);
            return;
        }
        String temp = worker.get(nextPerson);
        worker.set(nextPerson, worker.get(INITIAL_INDEX));
        worker.set(INITIAL_INDEX, temp);
    }

    private int getLastIndex() {
        return worker.size() - 1;
    }
}
