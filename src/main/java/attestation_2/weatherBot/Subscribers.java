import json.Parser;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Subscribers extends Thread {
    private static final Calendar day = Calendar.getInstance();
    private static final int[] time = new int[]{12, 0, 0};
    private static final long period = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);
    private final HashMap<String, User> subscribers;
    private final Timer timer;

    public Subscribers() {
        subscribers = new HashMap<>();
        day.set(Calendar.HOUR_OF_DAY, time[0]);
        day.set(Calendar.MINUTE, time[1]);
        day.set(Calendar.SECOND, time[2]);
        timer = new Timer();
    }

    public void add(User user) {
        this.subscribers.put(user.getChatId(), user);
    }

    public void remove(User user) {
        this.subscribers.remove(user.getChatId());
    }

    public boolean hasId(String id) { return this.subscribers.containsKey(id); }

    @Override
    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Map.Entry<String, User> entry: subscribers.entrySet()) {
                    entry.getValue().sendCurrent();
                }
            }
        }, day.getTime(), period);
    }
}