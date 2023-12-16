package oncall.domain;

import java.util.List;

public class Worker {
    private List<String> worker;
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

    public String checkNextPerson() {
        if (nextPerson == worker.size()) {
            nextPerson = 0;
        }
        return worker.get(nextPerson);
    }

    public void changeOrder() {
        if (nextPerson < worker.size() - 1) {
            String temp = worker.get(nextPerson);
            worker.set(nextPerson, worker.get(nextPerson + 1));
            worker.set(nextPerson + 1, temp);
            return;
        }
        String temp = worker.get(nextPerson);
        worker.set(nextPerson, worker.get(0));
        worker.set(0, temp);
    }
}
