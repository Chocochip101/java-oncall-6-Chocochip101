package oncall.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.global.Config;

public class Workers {
    private final Worker weekDayWorkers;
    private final Worker weekEndWorkers;

    public Workers(List<String> weekDayWorkers, List<String> weekEndWorkers) {
        validate(weekDayWorkers, weekEndWorkers);
        this.weekDayWorkers = new Worker(weekDayWorkers);
        this.weekEndWorkers = new Worker(weekEndWorkers);
    }

    private void validate(List<String> weekDayWorkers, List<String> weekEndWorkers) {
        Set<String> workers = new HashSet<>();
        workers.addAll(weekDayWorkers);
        workers.addAll(weekEndWorkers);
        if (workers.size() > Config.MAX_WORKER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
