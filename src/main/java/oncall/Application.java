package oncall;

import oncall.scheduler.OnCallScheduler;

public class Application {
    public static void main(String[] args) {
        new OnCallScheduler().start();
    }
}
