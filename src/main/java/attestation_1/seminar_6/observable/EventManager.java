package attestation_1.seminar_6.observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
        this.listeners.put("all", new ArrayList<>());
    }

    public void bind(String eventType, EventListener listener) {
        List<EventListener> callbacks = listeners.get(eventType);
        callbacks.add(listener);
        listeners.get("all").add(listener);
    }

    public void unbind(String eventType, EventListener listener) {
        List<EventListener> callbacks = listeners.get(eventType);
        callbacks.remove(listener);
        listeners.get("all").remove(listener);
    }

    public <T> void notify(String eventType, T obj) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, obj);
        }
    }
}
