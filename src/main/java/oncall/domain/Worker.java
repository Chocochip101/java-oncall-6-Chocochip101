package oncall.domain;

import java.util.List;

public class Worker {
    private final List<String> worker;
    private int nextPerson;

    public Worker(List<String> worker) {
        this.worker = worker;
        nextPerson = 0;
    }

    public String getNextPerson() {
        if (nextPerson == worker.size()) {
            nextPerson = 0;
        }
        return worker.get(nextPerson++);
    }
}
